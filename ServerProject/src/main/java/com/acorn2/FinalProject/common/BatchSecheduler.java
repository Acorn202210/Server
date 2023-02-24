package com.acorn2.FinalProject.common;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.acorn2.FinalProject.notice.service.NoticeService;
import com.acorn2.FinalProject.users.service.UsersService;

@Component
public class BatchSecheduler {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired private NoticeService noticeService;
	@Autowired private UsersService usersService;


	@Scheduled(cron = "0 5 0 * * *")
	public void testSchedule() {
		noticeService.deleteNotice();
		usersService.batchUser();
		
		logger.info("[Mytest] Notice delete {}", LocalDateTime.now());
	}

}
