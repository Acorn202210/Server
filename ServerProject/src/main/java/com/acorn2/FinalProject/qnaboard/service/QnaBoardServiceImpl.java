package com.acorn2.FinalProject.qnaboard.service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.qnaboard.dao.QnaBoardAnswerDao;
import com.acorn2.FinalProject.qnaboard.dao.QnaBoardDao;
import com.acorn2.FinalProject.qnaboard.dto.QnaBoardAnswerDto;
import com.acorn2.FinalProject.qnaboard.dto.QnaBoardDto;
import com.acorn2.FinalProject.qnaboard.dto.QnaBoardReq;
import com.acorn2.FinalProject.qnaboard.dto.QnaBoardRes;

@Service
public class QnaBoardServiceImpl implements QnaBoardService {
	
	@Autowired private QnaBoardDao qnaDao;
	@Autowired private QnaBoardAnswerDao qnaAnswerDao;
	
	@Override
	public List<QnaBoardDto> getList(int pageNum, String keyword, String condition) {
		final int PAGE_ROW_COUNT=5;
		final int PAGE_DISPLAY_COUNT=5;
		
		int num=1;
		String strPageNum=Integer.toString(pageNum);
		if(strPageNum != null){
			num=Integer.parseInt(strPageNum);
		}
		
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		int endRowNum=pageNum*PAGE_ROW_COUNT;
	
		if(keyword==null){
			keyword="";
			condition="";
		}
		String encodedK=URLEncoder.encode(keyword);
			
		QnaBoardDto dto=new QnaBoardDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		if(!keyword.equals("")){
			if(condition.equals("title_content")){
				
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")){
				dto.setTitle(keyword);
			}
		}
		
		List<QnaBoardDto> list=qnaDao.getList(dto);
		
		int totalRow=qnaDao.getCount(dto);
				
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
				
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount;
		}
		
		return list;
	}

	@Override
	public Map<String, Object> getDetail(int num, String keyword, String condition) {
		//조회수 올리기
		qnaDao.addViewCount(num);
		
		  /*
        [ 검색 키워드에 관련된 처리 ]
        -검색 키워드가 파라미터로 넘어올수도 있고 안넘어 올수도 있다.      
	     */
	     
	     //만일 키워드가 넘어오지 않는다면 
	     if(keyword==null){
	        //키워드와 검색 조건에 빈 문자열을 넣어준다. 
	        //클라이언트 웹브라우저에 출력할때 "null" 을 출력되지 않게 하기 위해서  
	        keyword="";
	        condition=""; 
	     }
	     //QnaBoardDto 객체를 생성해서 
	     QnaBoardDto dto=new QnaBoardDto();
	     //자세히 보여줄 글번호를 넣어준다. 
	     dto.setNum(num);
	     //만일 검색 키워드가 넘어온다면 
	     if(!keyword.equals("")){
	        //검색 조건이 무엇이냐에 따라 분기 하기
	        if(condition.equals("title_content")){//제목 + 내용 검색인 경우
	           //검색 키워드를 QnaBoardDto 에 담아서 전달한다.
	           dto.setTitle(keyword);
	           dto.setContent(keyword);         
	        }else if(condition.equals("title")){ //제목 검색인 경우
	           dto.setTitle(keyword);   
	        }else if(condition.equals("writer")){ //작성자 검색인 경우
	           dto.setWriter(keyword);   
	        } // 다른 검색 조건을 추가 하고 싶다면 아래에 else if() 를 계속 추가 하면 된다.
	     }
		
		//글 하나의 정보를 얻어온다.
		QnaBoardDto resultDto=qnaDao.getData(dto);
		//특수기호를 인코딩한 키워드를 미리 준비한다.
		String encodedK=URLEncoder.encode(keyword);
		
		 /*
	     * [ 댓글 페이징 처리에 관련된 로직 ]
	     */
	     //한 페이지에 몇개씩 표시할 것인지
	     final int PAGE_ROW_COUNT=10;
	
	     //detail.jsp 페이지에서는 항상 1페이지의 댓글 내용만 출력한다. 
	     int pageNum=1;
	
	     //보여줄 페이지의 시작 ROWNUM
	     int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
	     //보여줄 페이지의 끝 ROWNUM
	     int endRowNum=pageNum*PAGE_ROW_COUNT;
	
	     //원글의 글번호를 이용해서 해당글에 달린 댓글 목록을 얻어온다.
	     QnaBoardAnswerDto qnaAnswerDto=new QnaBoardAnswerDto();
	     qnaAnswerDto.setRef_group(num);
	     //1페이지에 해당하는 startRowNum 과 endRowNum 을 dto 에 담아서  
	     qnaAnswerDto.setStartRowNum(startRowNum);
	     qnaAnswerDto.setEndRowNum(endRowNum);
	
	     //1페이지에 해당하는 댓글 목록만 select 되도록 한다. 
	     List<QnaBoardAnswerDto> commentList=qnaAnswerDao.getList(qnaAnswerDto);
	
	     //원글의 글번호를 이용해서 댓글 전체의 갯수를 얻어낸다.
	     int totalRow=qnaAnswerDao.getCount(num);
	     //댓글 전체 페이지의 갯수
	     int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		
	     Map<String, Object> map = new HashMap<String, Object>();
	     map.put("dto", resultDto);
	     map.put("condition", condition);
		 map.put("keyword", keyword);
		 map.put("encodedK", encodedK);
		 map.put("totalRow", totalRow);
		 map.put("commentList", commentList);
		 map.put("totalPageCount", totalPageCount);
		 
		 return map;
	}

	@Override
	public Map<String, String> saveContent(QnaBoardRes dto) {
		qnaDao.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("isSuccess","success");

		return map;		
	}

	@Override
	public Map<String, String> updateContent(QnaBoardReq dto) {
		qnaDao.update(dto);
		
		Map<String,String> map=new HashMap<>();
		return map;
	}

	@Override
	public Map<String, String> deleteContent(int num) {
		qnaDao.delete(num);
		
		Map<String,String> map=new HashMap<String, String>();
		map.put("isSuccess", "success");
		
		return map;
	}

	@Override
	public Map<String, Object> getData(int num) {
		//수정할 글의 정보 얻어와서
		QnaBoardDto dto=qnaDao.getData(num);
		Map<String, Object> map=new HashMap<>();
		map.put("isSuccess", "success");		
		map.put("dto", dto);
		
		return map;
	}

}
