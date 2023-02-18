package com.acorn2.FinalProject.faq.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.acorn2.FinalProject.faq.controller.valid.InsertFaq;

/**
 * @systemName : Project
 * @programName : FaqDtoSample
 * @author : 이성진
 * @createDate : 2023. 2. 15.
 * @description :
// */
//public class FaqSampleDto extends ComPagingDto {
//	private Integer num;
//	@NotNull(groups = {
//			InsertFaq.class })
//	private String question;
//	@NotEmpty(groups = {
//			InsertFaq.class })
//	private String content;
//	private int startRowNum;
//	private int endRowNum;
//	private int prevNum; //이전글의 글번호
//	private int nextNum; //다음글의 글번호
//
//	public Integer getNum() {
//		return num;
//	}
//
//	public void setNum(Integer num) {
//		this.num = num;
//	}
//
//	public String getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(String question) {
//		this.question = question;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public int getStartRowNum() {
//		return startRowNum;
//	}
//
//	public void setStartRowNum(int startRowNum) {
//		this.startRowNum = startRowNum;
//	}
//
//	public int getEndRowNum() {
//		return endRowNum;
//	}
//
//	public void setEndRowNum(int endRowNum) {
//		this.endRowNum = endRowNum;
//	}
//
//	public int getPrevNum() {
//		return prevNum;
//	}
//
//	public void setPrevNum(int prevNum) {
//		this.prevNum = prevNum;
//	}
//
//	public int getNextNum() {
//		return nextNum;
//	}
//
//	public void setNextNum(int nextNum) {
//		this.nextNum = nextNum;
//	}
//}
