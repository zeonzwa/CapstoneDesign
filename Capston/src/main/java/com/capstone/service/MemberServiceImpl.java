package com.capstone.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;
import com.capstone.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO dao;

	// 회원 가입
	@Override 
	public void signup(MemberVO vo) throws Exception {
		dao.signup(vo);		
	}
	
	// 로그인
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return dao.signin(vo);
	}

	// 로그아웃
	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();  // 세션 정보를 제거
	}
	
	//아이디 중복체크
	@Override
	public MemberVO idChk(String Id) throws Exception{
		return dao.idChk(Id);
	}
	
	//거래 조회
	public List<TradeVO> tradeView(String Id) throws Exception{
		return dao.tradeView(Id);
	}
}