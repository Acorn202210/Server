package com.acorn2.FinalProject.notice.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.acorn2.FinalProject.notice.dto.req.NoticeCreateReqDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeUpdateReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadDetailResDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadListResDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadResDto;


public interface NoticeService {
	NoticeReadListResDto selectNoticeList(NoticeReadReqDto noticeReadReqDto);
	NoticeReadDetailResDto selectNoticeOne(NoticeReadReqDto noticeReadReqDto);
	void insertNotice(NoticeCreateReqDto noticeCreateReqDto, HttpServletRequest request);
	void updateNotice(NoticeUpdateReqDto noticeUpdateReqDto, HttpServletRequest request);
	void deleteUpdateNotice(Integer notiNum);
	void deleteNotice();
}
