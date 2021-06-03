package com.capstone.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.domain.Talent_B_VO;
import com.capstone.domain.Talent_S_VO;
import com.capstone.service.TalentService;
import com.capstone.domain.MemberVO;

@Controller
@RequestMapping("/talent/*")
public class TalentController {

	private static final Logger logger = LoggerFactory.getLogger(TalentController.class);
	
	@Inject
	TalentService talentService;
	
	
	//재능 판매 등록 get
	@RequestMapping(value="/talent_S_reg", method=RequestMethod.GET)
	public void getTalent_S_Register(Model model) throws Exception{
		logger.info("get Tals_S_Register");
	}
	
	//재능 판매 등록 post
	@RequestMapping(value="/talent_S_reg", method=RequestMethod.POST)
	public String postTalent_S_Register(Talent_S_VO vo, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		MemberVO seller = (MemberVO) session.getAttribute("member");
		vo.setTals_Id(seller.getId());	
		vo.setPhone_Num(seller.getPhone_Num());
		
		talentService.register(vo);
		
		return "redirect:/talent/talent_S_list";
	}
	
	
	//재능 판매 수정 get
	@RequestMapping(value="/talent_S_modify", method=RequestMethod.GET)
	public void getTalentModify(@RequestParam("n") int Tals_Code, Model model) throws Exception{
		logger.info("get talent modify");
		
		Talent_S_VO talent=talentService.talentSview(Tals_Code);
		model.addAttribute("talent",talent);
	}
	
	//재능 판매 수정 post
	@RequestMapping(value="/talent_S_modify", method=RequestMethod.POST)
	public String postTalentModify(Talent_S_VO vo, HttpServletRequest req) throws Exception{
		logger.info("post modify");
		
		talentService.talentModify(vo);
		return "redirect:/talent/talent_S_list";
	}
	
	
	//재능 판매 삭제
	@RequestMapping(value="/talent_S_delete",method=RequestMethod.GET)
	public String getTalentDelete(@RequestParam("n") int tals_Code) throws Exception{
		logger.info("post talent delete");
		talentService.talentDelete(tals_Code);
		
		return "redirect:/talent/talent_S_list";
	}
	
	//재능 판매 화면 출력
	@RequestMapping(value="/talent_S_list",method=RequestMethod.GET)
	public void getTalentList(Model model, HttpServletRequest req) throws Exception{
		logger.info("get talent_S_list");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<Talent_S_VO>list=talentService.talentSlist();
		model.addAttribute("member",member);
		model.addAttribute("list",list);
	}
	
	
	//재능 판매 상세 조회
	@RequestMapping(value="/talent_S_view", method=RequestMethod.GET)
	public void getTalentView(@RequestParam("n") int Tals_Code, Model model, HttpServletRequest req) throws Exception{
		logger.info("get talent view");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		Talent_S_VO talent = talentService.talentSview(Tals_Code);
		model.addAttribute("talent", talent);
		model.addAttribute("member", member);
	}
	
	
//////////////여기까지 재능 판매 관련
	//재능 구매 등록 get
	
	
	//재능 구매 등록 post
		
		
	//재능 구매 수정 get
		
		
	//재능 구매 수정 post
		
	
	//재능 구매 삭제
		
		
	//재능 구매 화면 출력
		
		
	//재능 구매 상세 조회
	
//////////////여기까지 재능 구매 관련
	
	
	
	
	
	
	
	
	
}
