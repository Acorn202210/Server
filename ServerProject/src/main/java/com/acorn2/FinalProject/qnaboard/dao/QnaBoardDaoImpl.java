package com.acorn2.FinalProject.qnaboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn2.FinalProject.qnaboard.dto.QnaBoardDto;
import com.acorn2.FinalProject.qnaboard.dto.QnaBoardReq;
import com.acorn2.FinalProject.qnaboard.dto.QnaBoardRes;

@Repository
public class QnaBoardDaoImpl implements QnaBoardDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<QnaBoardDto> getList(QnaBoardDto dto) {
		return session.selectList("qnaboard.getList", dto);
	}

	@Override
	public int getCount(QnaBoardDto dto) {
		
		return session.selectOne("qnaboard.getCount", dto);
	}

	@Override
	public void insert(QnaBoardRes dto) {
		
		session.insert("qnaboard.insert", dto);		
	}

	@Override
	public QnaBoardDto getData(int num) {

		return session.selectOne("qnaboard.getData", num);
	}

	@Override
	public QnaBoardDto getData(QnaBoardDto dto) {
		
		return session.selectOne("qnaboard.getData2", dto);
	}

	@Override
	public void addViewCount(int num) {
		
		session.update("qnaboard.addViewCount", num);
	}

	@Override
	public void delete(int num) {		
		session.delete("qnaboard.delete", num);		
	}

	@Override
	public void update(QnaBoardReq dto) {		
		session.update("qnaboard.update", dto);		
	}

	@Override
	public QnaBoardDto answered(QnaBoardDto dto) {
		return session.selectOne("qnaboard.answered", dto);
	}
	
}
