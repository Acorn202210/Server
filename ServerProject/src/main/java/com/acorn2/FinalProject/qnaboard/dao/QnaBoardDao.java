package com.acorn2.FinalProject.qnaboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.qnaboard.dto.QnaBoardDto;
import com.acorn2.FinalProject.qnaboard.dto.req.QnaBoardReadReqDto;
// import com.acorn2.FinalProject.qnaboard.dto.QnaBoardRes;
import com.acorn2.FinalProject.qnaboard.dto.res.QnaBoardReadResDto;

@Mapper
public interface QnaBoardDao {
//	//글목록
//	public List<QnaBoardDto> getList(QnaBoardDto dto);
//	//글의 갯수
//	public int getCount(QnaBoardDto dto);
//	//글 추가
//	public void insert(QnaBoardRes dto);
//	//글정보 얻어오기
//	public QnaBoardDto getData(int num);
//	//키워드를 활용한 글 정보 얻어오기(키워드에 부합하는 글 중에서 이전글, 다음글의 글번호도 얻어올 수 있도록)
//	public QnaBoardDto getData(QnaBoardDto dto);
//	//조회수 증가 시키기
//	public void addViewCount(int num);
//	//글 삭제
//	public void delete(int num);
//	//글 수정
//	public void update(QnaBoardReadReqDto dto);
//	//답변완료 추가
//	public QnaBoardDto answered(QnaBoardDto dto);
	
	/**
	 *
	 * @methodName : selectNoticeCount
	 * @author : syChoi
	 * @param qnaBoardReadReqDto
	 * @return
	 * @return : Integer
	 * @description : 1:1게시판 리스트 카운트 조회
	 */
	public Integer selectQnaBoardCount(QnaBoardReadReqDto qnaBoardReadReqDto);
	
	
	/**
	 *
	 * @methodName : selectNoticeList
	 * @author : syChoi
	 * @param qnaBoardReadReqDto
	 * @return
	 * @return : qnaBoardReadResDto
	 * @description : 공통코드 조회
	 */
	public List<QnaBoardReadResDto> selectQnaBoardList(QnaBoardReadReqDto qnaBoardReadReqDto);
}
