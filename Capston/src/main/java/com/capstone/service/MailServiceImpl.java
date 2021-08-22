package com.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.mapper.MailMapper;
import com.capstone.model.MailVO;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	MailMapper mailmapper;

	@Override
	public void memberJoin(MailVO mail) throws Exception {
		mailmapper.memberJoin(mail);
	}
	
	@Override
	public int idCheck(String memberId) throws Exception {
		
		return mailmapper.idCheck(memberId);
	}

}