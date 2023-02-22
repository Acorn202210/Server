package com.acorn2.FinalProject.common.dto;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.acorn2.FinalProject.notice.service.NoticeService;
import com.acorn2.FinalProject.qnaboard.service.QnaBoardService;

@Component
public class BatchSecheduler {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired private NoticeService service;
	@Autowired private QnaBoardService qnaService;

	@Scheduled(cron = "10 * * * * *")
	public void testSchedule() {
		service.deleteNotice();
		logger.info("[Mytest] Notice delete {}", LocalDateTime.now());;
	}

	@Scheduled(cron = "0 0/30 * * * *")
	public void qnaBoardSchedule() {
		qnaService.QnaBoardDelete();
		logger.info("[QnaBoardBatch] delete {}", LocalDateTime.now());
	}
}
