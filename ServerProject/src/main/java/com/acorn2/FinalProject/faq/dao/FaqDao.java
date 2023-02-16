package com.acorn2.FinalProject.faq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.faq.dto.req.FaqReadReqDto;
import com.acorn2.FinalProject.faq.dto.res.FaqReadResDto;

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
	 * @description : 공통코드 조회
	 */
	public List<FaqReadResDto> selectFaqList(FaqReadReqDto faqReadReqDto);
	
}
