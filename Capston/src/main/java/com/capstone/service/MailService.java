package com.capstone.service;

import com.capstone.model.MailVO;

public interface MailService {
	
	//이메일인증
	public void memberJoin(MailVO mail) throws Exception;
	
	// 아이디 중복 검사
	public int idCheck(String memberId) throws Exception;
}