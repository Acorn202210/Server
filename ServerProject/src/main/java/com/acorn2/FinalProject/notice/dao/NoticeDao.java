package com.acorn2.FinalProject.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.notice.dto.NoticeDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadResDto;



@Mapper
public interface NoticeDao {
//	public List<NoticeDto> getList(NoticeDto dto);
//	//글의 갯수
//	public int getCount(NoticeDto dto);
//	//글 추가
//	public void insert(NoticeReadResDto dto);
//	//글정보 얻어오기
//	public NoticeDto getData(int num);
//	//키워드를 활용한 글정보 얻어오기 (키워드에 부합하는 글중에서 이전글, 다음글의 글번호도 얻어올수 있도록)
//	public NoticeDto getData(NoticeDto dto);
//	//조회수 증가 시키기
//	public void addViewCount(int num);
//	//글 삭제
//	public void delete(int num);
//	//글 수정
//	public void update(NoticeReadReqDto dto);
	
	/**
	 *
	 * @methodName : selectNoticeCount
	 * @author : cheon
	 * @param NoticeReadReqDto
	 * @return
	 * @return : Integer
	 * @description : 공지사항 리스트 카운트 조회
	 */
	public Integer selectNoticeCount(NoticeReadReqDto noticeReadReqDto);
	
	/**
	 *
	 * @methodName : selectNoticeList
	 * @author : choen
	 * @param NoticeReadReqDto
	 * @return
	 * @return : NoticeReadResDto
	 * @description : 공통코드 조회
	 */
	public List<NoticeReadResDto> selectNoticeList(NoticeReadReqDto noticeReadReqDto);

}
