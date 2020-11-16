package com.tsis.businesscard.message.service;

import com.tsis.businesscard.vo.SendHistoryVO;

public interface MessageService {

	public boolean sendMessage(SendHistoryVO sendHistoryVO);

}