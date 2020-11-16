package com.tsis.businesscard.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsis.businesscard.message.dao.MessageDao;
import com.tsis.businesscard.vo.SendHistoryVO;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao messageDao;

	@Override
	public boolean sendMessage(SendHistoryVO sendHistoryVO) {
		// 메시지 전송 인터페이스 구현
		System.out.println("---- 메시지 전송 ---- : " + sendHistoryVO.toString());
		
		// if 성공 
		//전송 이력 입력;
		insertSendHistory(sendHistoryVO);
		
		
		
		
		// if 실패
		// return false
		
		
		return true;
	}
	
	private int insertSendHistory(SendHistoryVO sendHistoryVO) {
		return messageDao.insertSendHistory(sendHistoryVO);
	}
}
