package com.acorn2.FinalProject.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.acorn2.FinalProject.notice.exception.NoticeNotFoundException;

@RestController
//전역에 발생할 수 있는 예외를 처리해줌. 이게 @ExcptionalHandler와 차이점
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	 // 모든 예외를 처리하는 메소드
	 // Bean 내에서 발생하는 예외를 처리
	 @ExceptionHandler(Exception.class)
	 public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
	     ExceptionResponse exceptionResponse =
	             new ExceptionResponse("failed", new Date(), ex.getMessage(), request.getDescription(false));
	     return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 
	//사용자가 존재하지 않았을 때 처리하는 메소드
	 @ExceptionHandler(NoticeNotFoundException.class)
	 public final ResponseEntity<Object> handleNoticeNotFoundException(Exception ex, WebRequest request){
	     ExceptionResponse exceptionResponse =
	             new ExceptionResponse("failed", new Date(), ex.getMessage(), request.getDescription(false));
	     return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	 }
 
}
