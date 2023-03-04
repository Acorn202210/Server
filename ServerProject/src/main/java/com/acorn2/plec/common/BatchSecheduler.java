package com.acorn2.plec.common;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.acorn2.plec.api.faq.service.FaqService;
import com.acorn2.plec.api.lecture.Service.LectureService;
import com.acorn2.plec.api.lectureReview.service.LectureReviewService;
import com.acorn2.plec.api.lectureStudent.service.LectureStudentService;
import com.acorn2.plec.api.notice.service.NoticeService;
import com.acorn2.plec.api.qnaboard.service.QnaBoardService;
import com.acorn2.plec.api.users.service.UsersService;


@Component
public class BatchSecheduler {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired private NoticeService noticeService;
	@Autowired private UsersService usersService;
	@Autowired private QnaBoardService qnaService;
	@Autowired private FaqService faqservice;
	@Autowired private LectureService lectureService;
	@Autowired private LectureReviewService lectureReviewService;
	@Autowired private LectureStudentService lectureStudentService;

	@Scheduled(cron = "0 5 0 * * *")
	public void schedule() {
		logger.info("[delete Schedule] Schedule Start [TIME:{}]", LocalDateTime.now());

		noticeService.deleteNotice();
		faqservice.deleteFaq();
		usersService.batchUser();
		lectureService.batchLectureDelete();
		lectureReviewService.batchDeleteLectureReview();
		lectureStudentService.LectureDelete();
		qnaService.QnaBoardDelete();

		logger.info("[delete Schedule] Schedule End [TIME:{}]", LocalDateTime.now());
	}
}
