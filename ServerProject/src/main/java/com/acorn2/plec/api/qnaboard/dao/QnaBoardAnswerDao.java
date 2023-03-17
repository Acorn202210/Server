package com.acorn2.plec.api.qnaboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.qnaboard.dto.QnaBoardAnswerDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardAnswerReadReqDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardAnswerReadResDto;

@Mapper
public interface QnaBoardAnswerDao {
//	//댓글 목록 얻어오기
//		public List<QnaBoardAnswerDto> getList(QnaBoardAnswerDto dto);	
//		//댓글 추가
//		public void insert(QnaBoardAnswerDto dto);
//		//추가할 댓글의 글번호를 리턴하는 메소드
//		public int getSequence();
//		//댓글 수정
//		public void update(QnaBoardAnswerDto dto);
//		//댓글 하나의 정보를 리턴하는 메소드
//		public QnaBoardAnswerDto getData(int num);
//		//댓글의 갯수를 리턴하는 메소드
//		public int getCount(int ref_group);
	
	
	//댓글개수
	public Integer selectQnaAnswerCount(QnaBoardAnswerReadReqDto answerReadReq);
	
	//댓글 목록
	public List<QnaBoardAnswerReadResDto> qnaAnswerList(QnaBoardAnswerReadReqDto answerReadReq);
		
	QnaBoardAnswerDto selectQnaAnswer(int boardCommentRefGroup);
	
	Integer insertQnaAnswer(QnaBoardAnswerDto dto);
	
	Integer updateQnaAnswer(QnaBoardAnswerDto dto);
	
	Integer deleteUpdateQnaAnswer(int boardCommentRefGroup);
	
	Integer deleteQnaBoard();	
	//댓글번호 미리 얻어내기
	Integer getSequence();
}
