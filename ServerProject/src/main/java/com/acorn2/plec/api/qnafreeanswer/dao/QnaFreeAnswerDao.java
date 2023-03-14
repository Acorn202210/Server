package com.acorn2.plec.api.qnafreeanswer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.qnafreeanswer.dto.QnaFreeAnswerDto;
import com.acorn2.plec.api.qnafreeanswer.dto.req.QnaFreeAnswerReadReqDto;
import com.acorn2.plec.api.qnafreeanswer.dto.res.QnaFreeAnswerReadDetailResDto;
import com.acorn2.plec.api.qnafreeanswer.dto.res.QnaFreeAnswerReadResDto;

@Mapper
public interface QnaFreeAnswerDao {

	/**
	 * 
	 * @methodName : selectQnaAnswerCount
	 * @author : jo
	 * @param QnaAnswerReadReqDto
	 * @return
	 * @return : Integer
	 * @description : 자유게시판 댓글 리스트 카운트 조회
	 */
	public Integer selectQnaFreeAnswerCount(QnaFreeAnswerReadReqDto dto);

	/**
	 *
	 * @methodName : selectQnaFreeAnswerList
	 * @author : jo
	 * @param QnaFreeAnswerReadReqDto
	 * @return
	 * @return : QnaFreeAnswerReadResDto
	 * @description : 자유게시판 댓글 조회
	 */
	public List<QnaFreeAnswerReadResDto> selectQnaFreeAnswerList(QnaFreeAnswerReadReqDto qnaFreeAnswerReadReqDto);

	/**
	 * 
	 * @methodName : selectQnaFreeAnswer
	 * @author : jo
	 * @param QnaFreeAnswerReadReqDto
	 * @return
	 * @return : QnaFreeAnswerReadResDto
	 * @description : 자유게시판 댓글 단건 조회
	 */

	public QnaFreeAnswerReadDetailResDto selectQnaFreeAnswer(QnaFreeAnswerReadReqDto qnaFreeAnswerReadReqDto);

	/**
	 * 
	 * @methodName : insertQnaFreeAnswer
	 * @author : jo
	 * @param QnaFreeAnswerdto
	 * @return
	 * @return : Integer
	 * @description : 자유게시판 댓글 등록
	 */
	Integer insertQnaFreeAnswer(QnaFreeAnswerDto dto);

	/**
	 * 
	 * @methodName : updateQnaFreeAnswer
	 * @author jo
	 * @param QnaFreeAnswerdto
	 * @return
	 * @return : Integer
	 * @description : 자유게시판 댓글 수정
	 */
	Integer updateQnaFreeAnswer(QnaFreeAnswerDto dto);

	/**
	 * 
	 * @methodName : deleteUpdateQnaFreeAnswer
	 * @author : jo
	 * @param QnaFreeAnswerDto
	 * @return
	 * @return : Integer
	 * @description : 자유게시판 댓글 삭제(deleteYncode Y로변경)
	 */
	Integer deleteUpdateQnaFreeAnswer(Integer freeCommentNum);

	Integer deleteQnaFreeAnswer();
}
