package com.acorn2.plec.common;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.acorn2.plec.faq.service.FaqService;
import com.acorn2.plec.lecture.Service.LectureService;
import com.acorn2.plec.lectureReview.service.LectureReviewService;
import com.acorn2.plec.lectureStudent.service.LectureStudentService;
import com.acorn2.plec.notice.service.NoticeService;
import com.acorn2.plec.qnaboard.service.QnaBoardService;
import com.acorn2.plec.users.service.UsersService;

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
//		logger로 기록하고, 위에것이 실패했을경우 넘겨서 다음것을 삭제하기 위한작업추가
//		schedulerLock은 두개에서 한쪽이하면 한쪽은 멈추고하는 작업, 시작시간, 끝나는시간 보이게끔작업
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
