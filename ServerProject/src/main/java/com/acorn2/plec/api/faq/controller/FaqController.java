package com.acorn2.plec.api.faq.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.plec.api.faq.dto.req.FaqCreateReqDto;
import com.acorn2.plec.api.faq.dto.req.FaqReadReqDto;
import com.acorn2.plec.api.faq.dto.req.FaqUpdateReqDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadDetailResDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadListResDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadResDto;
import com.acorn2.plec.api.faq.service.FaqService;
import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@Api("FaqController")
@RequestMapping("/api/faq")
public class FaqController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private FaqService service;

	@ApiOperation(value = "?????????????????? ??????", notes = "?????? ????????????????????? ????????? ????????????.")
	@GetMapping("/faq-list")
	public ComResponseEntity<FaqReadListResDto> getFaqList(@Parameter(hidden = true) FaqReadReqDto faqReadReqDto) {
		FaqReadListResDto faqReadListResDto = service.selectFaqList(faqReadReqDto);
		logger.debug("faqReadReqDto parameter : {}", faqReadReqDto.getFaqNum());
		return new ComResponseEntity<>(new ComResponseDto<>(faqReadListResDto));
	}

	@ApiOperation(value = "?????????????????? ?????? ??????????????????", notes = "????????????????????? ????????? ?????? ????????? ??????????????????.")
	@GetMapping("/faq-list/excel")
	public void FaqListExcelDownload(@Parameter(hidden = true) FaqReadReqDto faqReadReqDto, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		FaqReadListResDto faqReadListResDto = service.selectFaqList(faqReadReqDto);
		logger.debug("faqReadReqDto parameter : {}", faqReadReqDto);

		// ?????? ????????? ??????
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("??????????????????");

		// ????????? ????????? ?????????
		CellStyle headStyle = workbook.createCellStyle();

		// ?????????
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);

		// ?????????
		headStyle.setFillForegroundColor(HSSFColorPredefined.LIGHT_BLUE.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// ????????? ??????
		headStyle.setAlignment(HorizontalAlignment.CENTER);

		// ???????????? ?????????
		CellStyle bodyStyle = workbook.createCellStyle();

		// ?????????
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);

		// ????????? ??????
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);

		// ????????? ?????? ??????
		String[] headers = { "??????", "??????", "??????" };
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(headStyle);

			// ?????? ????????? ???????????? ??????
			sheet.autoSizeColumn(i);
			// ?????? ????????? ??? ?????? ??????
			sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 3000);
		}

		// ?????? ????????? ??????
		int rowNum = 1;
		for (FaqReadResDto faq : faqReadListResDto.getData()) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(faq.getFaqNum());
			row.createCell(1).setCellValue(faq.getQuestion());
			row.createCell(2).setCellValue(faq.getContent());

			// ???????????? ?????? ????????? ??????
			for (int i = 0; i < headers.length; i++) {
				row.getCell(i).setCellStyle(bodyStyle);

				// ?????? ????????? ???????????? ??????
				sheet.autoSizeColumn(i);
				// ?????? ????????? ??? ?????? ??????
				sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 2000);
			}
		}

		// ?????? ????????? ???????????? ????????????
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=FaqList.xlsx");
		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@ApiOperation(value = "?????? ?????????????????? ??????", notes = "????????? ????????????????????? ?????? ????????? ????????????.")
	@GetMapping(value = "/{faqNum}")
	public ComResponseEntity<FaqReadDetailResDto> getFaq(@Parameter(hidden = true) FaqReadReqDto faqReadReqDto) {
		FaqReadDetailResDto faqReadResDto = service.selectFaqOne(faqReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(faqReadResDto));
	}

	@ApiOperation(value = "?????????????????? ??????", notes = "????????????????????? ????????????.")
	@Transactional
	@PostMapping
	public ComResponseEntity<Void> insertFaq(@RequestBody FaqCreateReqDto faqCreateReqDto, HttpServletRequest request) {
		service.insertFaq(faqCreateReqDto, request);
		return new ComResponseEntity<Void>();
	}

	@ApiOperation(value = "?????????????????? ??????", notes = "????????????????????? ????????????.")
	@Transactional
	@PutMapping(value = "/{faqNum}/update")
	public ComResponseEntity<Void> updateFaq(@RequestBody FaqUpdateReqDto faqUpdateReqDto, HttpServletRequest request) {
		service.updateFaq(faqUpdateReqDto, request);
		return new ComResponseEntity<Void>();
	}

	@ApiOperation(value = "?????????????????? ??????", notes = "????????????????????? delete_YN_code??? 'Y'??? ????????????.")
	@Transactional
	@PutMapping(value = "/{faqNum}/delete")
	public ComResponseEntity<Void> deleteFaq(@PathVariable("faqNum") Integer faqNum) {
		service.deleteUpdateFaq(faqNum);
		return new ComResponseEntity<Void>();
	}

}