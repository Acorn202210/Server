package com.acorn2.plec.api.faq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.faq.dto.FaqDto;
import com.acorn2.plec.api.faq.dto.req.FaqReadReqDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadDetailResDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadResDto;

@Mapper
public interface FaqDao {

	/**
	 * 
	 * @methodName : selectFaqCount
	 * @author : jo
	 * @param FaqReadReqDto
	 * @return
	 * @return : Integer
	 * @description : 자주묻는질문 리스트 카운트 조회
	 */
	public Integer selectFaqCount(FaqReadReqDto faqReadReqDto);

	/**
	 *
	 * @methodName : selectFaqList
	 * @author : jo
	 * @param FaqReadReqDto
	 * @return
	 * @return : FaqReadResDto
	 * @description : 자주묻는질문 조회
	 */
	public List<FaqReadResDto> selectFaqList(FaqReadReqDto faqReadReqDto);

	/**
	 * 
	 * @methodName : selectFaq
	 * @author : jo
	 * @param FaqReadReqDto
	 * @return
	 * @return : FaqReadResDto
	 * @description : 자주묻는질문 단건 조회
	 */

	public FaqReadDetailResDto selectFaq(FaqReadReqDto faqReadReqDto);

	/**
	 * 
	 * @methodName : insertFaq
	 * @author : jo
	 * @param Faqdto
	 * @return
	 * @return : Integer
	 * @description : 자주묻는질문 등록
	 */
	Integer insertFaq(FaqDto dto);

	/**
	 * 
	 * @methodName : deleteUpdateFaq
	 * @author : jo
	 * @param FaqDto
	 * @return
	 * @return : Integer
	 * @description : 자주묻는질문 삭제(deleteYncode Y로변경)
	 */
	Integer deleteUpdateFaq(Integer faqNum);

	/**
	 * 
	 * @methodName : updateFaq
	 * @author jo
	 * @param Faqdto
	 * @return
	 * @return : Integer
	 * @description : 자주묻는질문 수정
	 */
	Integer updateFaq(FaqDto dto);

	/**
	 * 
	 * @methodName : deleteUpdateFaq
	 * @author : jo
	 * @param FaqDto
	 * @return
	 * @return : Integer
	 * @description : 자주묻는질문 DB삭제
	 */
	Integer deleteFaq();
}
