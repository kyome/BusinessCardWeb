package com.tsis.businesscard.message.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsis.businesscard.vo.SendHistoryVO;

@Repository
public class MessageDao  {

	@Autowired
	private SqlSessionTemplate session;

	public int insertSendHistory(SendHistoryVO sendHistoryVO) {
		return session.insert("message.insertSendHistory",sendHistoryVO);
	}

}
