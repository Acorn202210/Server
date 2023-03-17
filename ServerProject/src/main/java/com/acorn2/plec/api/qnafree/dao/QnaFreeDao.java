package com.acorn2.plec.api.qnafree.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.qnafree.dto.QnaFreeDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeReadReqDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadDetailResDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadResDto;

@Mapper
public interface QnaFreeDao {

	/**
	 *
	 * @methodName : selectQnaFreeCount
	 * @author : jo
	 * @param qnaFreeReadReqDto
	 * @return
	 * @return : Integer
	 * @description : 자유게시판 리스트 카운트 조회
	 */
	public Integer selectQnaFreeCount(QnaFreeReadReqDto qnaFreeReadReqDto);

	/**
	 *
	 * @methodName : selectQnaFreeList
	 * @author : jo
	 * @param QnaFreeReadReqDto
	 * @return
	 * @return : QnaFreeReadResDto
	 * @description : 자유게시판 조회
	 */
	public List<QnaFreeReadResDto> selectQnaFreeList(QnaFreeReadReqDto qnaFreeReadReqDto);

	/**
	 * 
	 * @methodName : insertQnaFree
	 * @author : jo
	 * @param QnaFreedto
	 * @return
	 * @return : Integer
	 * @description : 자유게시판 등록
	 */
	Integer insertQnaFree(QnaFreeDto dto);

	/**
	 * 
	 * @methodName : updateQnaFree
	 * @author jo
	 * @param QnaFreedto
	 * @return
	 * @return : Integer
	 * @description : 자유게시판 수정
	 */
	Integer updateQnaFree(QnaFreeDto dto);

	/**
	 * 
	 * @methodName : deleteUpdateQnaFree
	 * @author : jo
	 * @param QnaFreeDto
	 * @return
	 * @return : Integer
	 * @description : 자유게시판 삭제(deleteYncode Y로변경)
	 */
	Integer deleteUpdateQnaFree(int free_question_num);

	/**
	 *
	 * @methodName : addViewCount
	 * @author : cheon
	 * @param Integer
	 * @return
	 * @return : Integer
	 * @description : 자유게시판 조회수 추가
	 */
	Integer addViewCount(Integer freeQuestionNum);

	/**
	 * 
	 * @methodName : selectQnaFree
	 * @author : jo
	 * @param QnaFreeReadReqDto
	 * @return
	 * @return : QnaFreeReadResDto
	 * @description : 자유게시판 단건 조회
	 */
	public QnaFreeReadDetailResDto selectQnaFree(QnaFreeReadReqDto qnaFreeReadReqDto);

	Integer deleteQnaFree();
}
