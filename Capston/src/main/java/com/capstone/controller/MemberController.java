package com.capstone.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.domain.GoodsVO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;
import com.capstone.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	
	// 회원 가입 get
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void getSignup() throws Exception {
		logger.info("get signup");
	}
	
	// 회원 가입 post
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postSignup(MemberVO vo) throws Exception {
		logger.info("post signup");	
		 service.signup(vo);
		 
		return "redirect:/";
	}
	// 로그인  get
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void getSignin() throws Exception {
		logger.info("get signin");
	}
	// 로그인 post
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
		public String postSignin(MemberVO vo, Model model, HttpServletRequest req, RedirectAttributes rttr, HttpServletResponse response) throws Exception {
			logger.info("post signin");
			
			MemberVO login = service.signin(vo);  // MemverVO형 변수 login에 로그인 정보를 저장
			HttpSession session = req.getSession();  // 현재 세션 정보를 가져옴
			if(login==null){
				model.addAttribute("msg","ID나PW가 틀립니다.");
				return "member/signin";
			}else{
				session.setAttribute("member", login);
				
				List<TradeVO> list = service.tradeView(login.getId());
				response.setContentType("text/html; charset=UTF-8");
				 
				PrintWriter out = response.getWriter();
				if(list.size()==0) {
					out.println("<script language='javascript'>");
					out.println("alert('충대 장터에 오신것을 환영합니다.');");
					out.println("</script>");
					 
					out.flush();
				}
				else {					 
					out.println("<script language='javascript'>");
					out.println("alert('완료된 거래 중 작성하지 않은 후기가 있습니다.');");
					out.println("</script>");
					 
					out.flush();
				}
			}
			return "/move/index";
					
	}	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		 logger.info("get logout");
		 
		 session.invalidate();
		   
		 return "redirect:/";
	}
	
	//관리자로그인 get
	@RequestMapping(value="/sign",method=RequestMethod.GET)
	public void getManagerSignin() throws Exception{
		logger.info("get managersignin");
	}
	
	//관리자 로그인 post
	@RequestMapping(value="/sign" , method = RequestMethod.POST)
	public String postManagerSignin(MemberVO vo, Model model, HttpServletRequest req, RedirectAttributes rttr, HttpServletResponse response) throws Exception{
		logger.info("post managersignin");
		
		MemberVO login=service.managersignin(vo);
		HttpSession session = req.getSession();
		if(login==null){
			model.addAttribute("msg","ID나PW가 틀립니다.");
			return "member/signin";
		}
		else {
			session.setAttribute("member", login);
			
			List<TradeVO> list = service.tradeView(login.getId());
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			if(list.size()==0) {
				out.println("<script language='javascript'>");
				out.println("alert('관리자 페이지에 오신것을 환영합니다.');");
				out.println("</script>");
				 
				out.flush();
			}
			else {					 
				out.println("<script language='javascript'>");
				out.println("alert('완료된 거래 중 작성하지 않은 후기가 있습니다.');");
				out.println("</script>");
				 
				out.flush();
			}
		}
		return "/move/manager";
	}
	
	//아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="/idChk", method = RequestMethod.POST)
	public int postIdChk(HttpServletRequest req, MemberVO vo) throws Exception{
		String user = req.getParameter("Id");
		MemberVO result = service.idChk(user);
		if(result ==null) {
			return 2;
		}
		else return 1;
	}

}
