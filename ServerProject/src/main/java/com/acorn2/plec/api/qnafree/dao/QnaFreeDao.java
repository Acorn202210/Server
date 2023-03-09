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
	 * @author : originChoi
	 * @param qnaFreeReadReqDto
	 * @return
	 * @return : Integer
	 * @description : 자유게시판 리스트 카운트 조회
	 */
	public Integer selectQnaFreeCount(QnaFreeReadReqDto qnaFreeReadReqDto);
	
	
	/**
	 *
	 * @methodName : selectQnaFreeList
	 * @author : originChoi
	 * @param qnaFreeReadReqDto
	 * @return
	 * @return : qnaFreeReadResDto
	 * @description : 공통코드 조회
	 */
	public List<QnaFreeReadResDto> selectQnaFreeList(QnaFreeReadReqDto qnaFreeReadReqDto);
	
	
	Integer insertQnaFree(QnaFreeDto dto);
	
	Integer updateQnaFree(QnaFreeDto dto);
	
	Integer deleteUpdateQnaFree(int free_question_num);
	
	Integer deleteQnaFree();
	
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
	
	//detail 보기
	public QnaFreeReadDetailResDto selectQnaFree(QnaFreeReadReqDto qnaFreeReadReqDto);
}
