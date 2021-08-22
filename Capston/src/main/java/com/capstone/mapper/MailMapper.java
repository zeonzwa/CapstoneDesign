package com.capstone.mapper;

import com.capstone.model.MailVO;

public interface MailMapper {
	
	//이메일인증
	public void memberJoin(MailVO mail);
	
	// 아이디 중복 검사
	public int idCheck(String memberId);
}