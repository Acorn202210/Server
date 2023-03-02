package com.acorn2.FinalProject.common;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.acorn2.FinalProject.faq.service.FaqService;
import com.acorn2.FinalProject.lecture.Service.LectureService;
import com.acorn2.FinalProject.lectureReview.service.LectureReviewService;
import com.acorn2.FinalProject.lectureStudent.service.LectureStudentService;
import com.acorn2.FinalProject.notice.service.NoticeService;
import com.acorn2.FinalProject.qnaboard.service.QnaBoardService;
import com.acorn2.FinalProject.users.service.UsersService;

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
	public void testSchedule() {
		noticeService.deleteNotice();
		faqservice.deleteFaq();
		usersService.batchUser();
		lectureService.batchLectureDelete();
		lectureReviewService.batchDeleteLectureReview();
		lectureStudentService.LectureDelete();
		
		logger.info("[Mytest] Notice delete {}", "[Mytest] Faq delete {}", LocalDateTime.now());
	}

	@Scheduled(cron = "0 0/30 * * * *")
	public void qnaBoardSchedule() {
		qnaService.QnaBoardDelete();
		logger.info("[QnaBoardBatch] delete {}", LocalDateTime.now());
	}
}
