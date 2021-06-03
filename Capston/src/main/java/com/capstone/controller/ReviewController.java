package com.capstone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.domain.MemberVO;
import com.capstone.domain.ReviewVO;

@Controller
@RequestMapping("/review/*")
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	//후기 작성 get
	@RequestMapping(value = "/review_reg", method = RequestMethod.GET)
	public void getReviewReg(@RequestParam("n") int goods_Code, Model model) throws Exception {
		logger.info("get review register");
	}
	
	//후기 작성 post
	@RequestMapping(value = "/review_reg", method = RequestMethod.POST)
	public void postReviewReg(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req, ReviewVO vo) throws Exception {
		logger.info("post review register");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
	}
	
	//후기 수정 get
	
	
	//후기 수정 post
	
	
	//후기 삭제

	
	//후기 관리 화면 출력
	
	
}
