package com.capstone.service;

import javax.servlet.http.HttpSession;

import com.capstone.domain.MemberVO;

public interface MemberService {
	
	public void signup(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO signin(MemberVO vo) throws Exception;
		
	// 로그아웃
	public void signout(HttpSession session) throws Exception;
}