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
import com.acorn2.plec.common.utils.SessionUtils;

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

	@ApiOperation(value = "자주묻는질문 목록", notes = "모든 자주묻는질문의 목록을 가져온다.")
	@GetMapping("/faq-list")
	public ComResponseEntity<FaqReadListResDto> getFaqList(@Parameter(hidden = true) FaqReadReqDto faqReadReqDto) {
		FaqReadListResDto faqReadListResDto = service.selectFaqList(faqReadReqDto);
		logger.debug("faqReadReqDto parameter : {}", faqReadReqDto.getFaqNum());
		return new ComResponseEntity<>(new ComResponseDto<>(faqReadListResDto));
	}

	@ApiOperation(value = "자주묻는질문 목록 엑셀다운로드", notes = "자주묻는질문의 목록을 엑셀 파일로 다운로드한다.")
	@GetMapping("/faq-list/excel")
	public void FaqListExcelDownload(@Parameter(hidden = true) FaqReadReqDto faqReadReqDto, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		FaqReadListResDto faqReadListResDto = service.selectFaqList(faqReadReqDto);
		logger.debug("faqReadReqDto parameter : {}", faqReadReqDto);

		// 엑셀 워크북 생성
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("자주묻는질문");

		// 테이블 헤더용 스타일
		CellStyle headStyle = workbook.createCellStyle();

		// 경계선
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);

		// 배경색
		headStyle.setFillForegroundColor(HSSFColorPredefined.LIGHT_BLUE.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// 가운데 정렬
		headStyle.setAlignment(HorizontalAlignment.CENTER);

		// 데이터용 스타일
		CellStyle bodyStyle = workbook.createCellStyle();

		// 경계선
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);

		// 가운데 정렬
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);

		// 테이블 헤더 생성
		String[] headers = { "번호", "질문", "내용" };
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(headStyle);

			// 열의 너비를 자동으로 조정
			sheet.autoSizeColumn(i);
			// 열의 너비를 더 넓게 조정
			sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 3000);
		}

		// 엑셀 데이터 생성
		int rowNum = 1;
		for (FaqReadResDto faq : faqReadListResDto.getData()) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(faq.getFaqNum());
			row.createCell(1).setCellValue(faq.getQuestion());
			row.createCell(2).setCellValue(faq.getContent());

			// 데이터용 경계 스타일 적용
			for (int i = 0; i < headers.length; i++) {
				row.getCell(i).setCellStyle(bodyStyle);

				// 열의 너비를 자동으로 조정
				sheet.autoSizeColumn(i);
				// 열의 너비를 더 넓게 조정
				sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 2000);
			}
		}

		// 엑셀 파일로 변환하여 다운로드
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=FaqList.xlsx");
		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@ApiOperation(value = "단일 자주묻는질문 상세", notes = "하나의 자주묻는질문의 상세 정보를 가져온다.")
	@GetMapping(value = "/{faqNum}")
	public ComResponseEntity<FaqReadDetailResDto> getFaq(@Parameter(hidden = true) FaqReadReqDto faqReadReqDto) {
		FaqReadDetailResDto faqReadResDto = service.selectFaqOne(faqReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(faqReadResDto));
	}

	@ApiOperation(value = "자주묻는질문 등록", notes = "자주묻는질문을 등록한다.")
	@Transactional
	@PostMapping
	public ComResponseEntity<Void> insertFaq(@RequestBody FaqCreateReqDto faqCreateReqDto, String id) {
		service.insertFaq(faqCreateReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}

	@ApiOperation(value = "자주묻는질문 수정", notes = "자주묻는질문을 수정한다.")
	@Transactional
	@PutMapping(value = "/{faqNum}/update")
	public ComResponseEntity<Void> updateFaq(@RequestBody FaqUpdateReqDto faqUpdateReqDto, String id) {
		service.updateFaq(faqUpdateReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}

	@ApiOperation(value = "자주묻는질문 삭제", notes = "자주묻는질문의 delete_YN_code를 'Y'로 수정한다.")
	@Transactional
	@PutMapping(value = "/{faqNum}/delete")
	public ComResponseEntity<Void> deleteFaq(@PathVariable("faqNum") Integer faqNum) {
		service.deleteUpdateFaq(faqNum);
		return new ComResponseEntity<Void>();
	}

}