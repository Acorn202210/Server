package com.acorn2.plec.api.qnafree.service;

import com.acorn2.plec.api.qnafree.dto.req.QnaFreeCreateReqDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeReadReqDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeUpdateReqDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadDetailResDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadListResDto;

public interface QnaFreeService {

	QnaFreeReadListResDto selectQnaFreeList(QnaFreeReadReqDto qnaFreeReadReqDto);

	QnaFreeReadDetailResDto selectQnaFreeOne(QnaFreeReadReqDto qnaFreeReadReqDto);

	void insertQnaFree(QnaFreeCreateReqDto qnaFreeCreateReqDto, String id);

	void updateQnaFree(QnaFreeUpdateReqDto qnaFreeUpdateReqDto);

	void deleteUpdateQnaFree(Integer freeQuestionNum);

	void deleteQnaFree();

}
