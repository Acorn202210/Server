package com.acorn2.plec.common.exception;

import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.acorn2.plec.common.ExceptionResponse;
import com.acorn2.plec.notice.exception.NoticeNotFoundException;
import com.acorn2.plec.users.exception.ManagerException;
import com.acorn2.plec.users.exception.UsersNotLoginException;

@RestController
//전역에 발생할 수 있는 예외를 처리해줌. 이게 @ExcptionalHandler와 차이점
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	 // 모든 예외를 처리하는 메소드
	 // Bean 내에서 발생하는 예외를 처리
	 @ExceptionHandler(Exception.class)
	 public final ResponseEntity<Object> handleAllExceptions(Exception ex){
	     ExceptionResponse exceptionResponse =
	             new ExceptionResponse( HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString(), new Date(), ExceptionUtils.getMessage(ex), ExceptionUtils.getStackTrace(ex));
	     return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 
	//공지사항이 존재하지 않았을 때 처리하는 메소드
	 @ExceptionHandler(NoticeNotFoundException.class)
	 public final ResponseEntity<Object> handleNoticeNotFoundException(Exception ex){
	     ExceptionResponse exceptionResponse =
	             new ExceptionResponse(HttpStatus.NOT_FOUND, "40000000", new Date(), ExceptionUtils.getMessage(ex), ExceptionUtils.getStackTrace(ex));
	     return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	 }
 
	//사용자가 존재하지 않았을 때 처리하는 메소드
	 @ExceptionHandler(UsersNotLoginException.class)
	 public final ResponseEntity<Object> handleUsersNotLoginException(Exception ex){
	     ExceptionResponse exceptionResponse =
	             new ExceptionResponse(HttpStatus.UNAUTHORIZED, "40000001", new Date(), ExceptionUtils.getMessage(ex), ExceptionUtils.getStackTrace(ex));
	     return new ResponseEntity(exceptionResponse, HttpStatus.UNAUTHORIZED);
	 }
	 
	//사용자가 존재하지 않았을 때 처리하는 메소드
	 @ExceptionHandler(ManagerException.class)
	 public final ResponseEntity<Object> handleManagerException(Exception ex){
	     ExceptionResponse exceptionResponse =
	             new ExceptionResponse(HttpStatus.FORBIDDEN, "40000003", new Date(), ExceptionUtils.getMessage(ex), ExceptionUtils.getStackTrace(ex));
	     return new ResponseEntity(exceptionResponse, HttpStatus.FORBIDDEN);
	 }
 
}
