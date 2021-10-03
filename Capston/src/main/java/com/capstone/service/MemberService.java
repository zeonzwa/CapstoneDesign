package com.capstone.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;

public interface MemberService {
	
	public void signup(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO signin(MemberVO vo) throws Exception;
		
	// 로그아웃
	public void signout(HttpSession session) throws Exception;
	
	//아디디 중복체크
	public MemberVO idChk(String Id) throws Exception;
	
	//거래 조회
	public List<TradeVO> tradeView(String Id) throws Exception;
	
	//관리자 로그인
	public MemberVO managersignin(MemberVO vo) throws Exception;
}