package com.acorn2.plec.api.qnafreeanswer.service;

import com.acorn2.plec.api.qnafreeanswer.dto.req.QnaFreeAnswerCreateReqDto;
import com.acorn2.plec.api.qnafreeanswer.dto.req.QnaFreeAnswerReadReqDto;
import com.acorn2.plec.api.qnafreeanswer.dto.req.QnaFreeAnswerUpdateReqDto;
import com.acorn2.plec.api.qnafreeanswer.dto.res.QnaFreeAnswerReadDetailResDto;
import com.acorn2.plec.api.qnafreeanswer.dto.res.QnaFreeAnswerReadListResDto;

public interface QnaFreeAnswerService {

	QnaFreeAnswerReadListResDto selectQnaFreeAnswerList(QnaFreeAnswerReadReqDto qnaFreeAnswerReadReqDto);

	QnaFreeAnswerReadDetailResDto selectQnaFreeAnswerOne(QnaFreeAnswerReadReqDto qnaFreeAnswerReadReqDto);

	void insertQnaFreeAnswer(QnaFreeAnswerCreateReqDto qnaFreeAnswerCreateReqDto, String id);

	void updateQnaFreeAnswer(QnaFreeAnswerUpdateReqDto qnaFreeAnswerUpdateReqDto, String id);

	void deleteUpdateQnaFreeAnswer(Integer freeCommentNum);

	void deleteQnaFreeAnswer();
}
