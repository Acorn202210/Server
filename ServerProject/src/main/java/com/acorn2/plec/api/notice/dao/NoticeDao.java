package com.acorn2.plec.api.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.notice.dto.NoticeDto;
import com.acorn2.plec.api.notice.dto.req.NoticeReadReqDto;
import com.acorn2.plec.api.notice.dto.res.NoticeReadDetailResDto;
import com.acorn2.plec.api.notice.dto.res.NoticeReadResDto;



@Mapper
public interface NoticeDao {
	
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
	 * @author : cheon
	 * @param NoticeReadReqDto
	 * @return
	 * @return : NoticeReadResDto
	 * @description : 공지사항 조회
	 */
	public List<NoticeReadResDto> selectNoticeList(NoticeReadReqDto noticeReadReqDto);
	
	/**
	 *
	 * @methodName : selectNotice
	 * @author : cheon
	 * @param NoticeReadReqDto
	 * @return
	 * @return : NoticeReadResDto
	 * @description : 공지사항 단건 조회
	 */
	public NoticeReadDetailResDto selectNotice(NoticeReadReqDto noticeReadReqDto);
	
	/**
	 *
	 * @methodName : insertNotice
	 * @author : cheon
	 * @param NoticeDto
	 * @return
	 * @return : Integer
	 * @description : 공지사항 등록
	 */
	Integer insertNotice(NoticeDto dto);
	/**
	 *
	 * @methodName : updateNotice
	 * @author : cheon
	 * @param NoticeDto
	 * @return
	 * @return : Integer
	 * @description : 공지사항 수정
	 */
	Integer updateNotice(NoticeDto dto);
	/**
	 *
	 * @methodName : updateNotice
	 * @author : cheon
	 * @param NoticeDto
	 * @return
	 * @return : Integer
	 * @description : 공지사항 수정
	 */
	Integer deleteUpdateNotice(Integer notiNum);
	/**
	 *
	 * @methodName : addViewCount
	 * @author : cheon
	 * @param Integer
	 * @return
	 * @return : Integer
	 * @description : 공지사항 조회수 추가
	 */
	Integer addViewCount(Integer notiNum);
	/**
	 *
	 * @methodName : updateNotice
	 * @author : cheon
	 * @param NoticeDto
	 * @return
	 * @return : Integer
	 * @description : 공지사항 수정
	 */
	Integer deleteNotice();
}
