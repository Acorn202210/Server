package com.acorn2.plec.api.notice.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.acorn2.plec.api.notice.dto.req.NoticeCreateReqDto;
import com.acorn2.plec.api.notice.dto.req.NoticeReadReqDto;
import com.acorn2.plec.api.notice.dto.req.NoticeUpdateReqDto;
import com.acorn2.plec.api.notice.dto.res.NoticeReadDetailResDto;
import com.acorn2.plec.api.notice.dto.res.NoticeReadListResDto;


public interface NoticeService {
	NoticeReadListResDto selectNoticeList(NoticeReadReqDto noticeReadReqDto);
	NoticeReadDetailResDto selectNoticeOne(NoticeReadReqDto noticeReadReqDto);
	void insertNotice(NoticeCreateReqDto noticeCreateReqDto, HttpServletRequest request);
	void updateNotice(NoticeUpdateReqDto noticeUpdateReqDto, HttpServletRequest request);
	void deleteUpdateNotice(Integer notiNum);
	void deleteNotice();
}
