package com.acorn2.plec.api.qnafree.dao;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.qnafree.dto.QnaFreeAnswerDto;


@Mapper
public interface QnaFreeAnswerDao {
	
	public Integer selectQnaAnswerCount(QnaFreeAnswerDto dto);
	
	QnaFreeAnswerDto selectQnaAnswer(int refGroup);
	
	Integer insertQnaAnswer(QnaFreeAnswerDto dto, HttpServletRequest request);
	
	Integer updateQnaAnswer(QnaFreeAnswerDto dto, HttpServletRequest request);
	
	Integer deleteUpdateQnaAnswer(int freeCommentNum);
	
	Integer deleteQnaFree();	
	//댓글번호 미리 얻어내기
	Integer getSequence();
}
