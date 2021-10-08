package com.capstone.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.domain.Criteria;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.PageMaker;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;
import com.capstone.service.AdminService;
import com.capstone.service.TalentService;

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
		
		return "redirect:/move/index";
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
		
		talentService.talentSModify(vo);
		return "redirect:/move/index";
	}
	
	
	//재능 판매 삭제
	@RequestMapping(value="/talent_S_delete",method=RequestMethod.POST)
	public String getTalentDelete(@RequestParam("n") int tals_Code) throws Exception{
		logger.info("post talent delete");
		talentService.talentDelete(tals_Code);
		
		return "redirect:/move/index";
	}
	
	//재능 판매 대분류 화면 출력 
	@RequestMapping(value="/talent_S_list",method=RequestMethod.GET)
	public void getTalentList(@RequestParam("n") String Kinds,Model model, HttpServletRequest req) throws Exception{
		logger.info("get talent_S_list");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<Talent_S_VO>list=talentService.talentSlist(Kinds);
		model.addAttribute("Kinds",Kinds);
		model.addAttribute("member",member);
		model.addAttribute("list",list);
	}
	
	//재능 판매 소분류 화면 출력 
	@RequestMapping(value="/talent_S_list_2",method=RequestMethod.GET)
	public void getTalentList_2(@RequestParam("n") String Kinds,Model model, HttpServletRequest req) throws Exception{
		logger.info("get talent_S_list_2");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<Talent_S_VO>list=talentService.talentSlist_2(Kinds);
		model.addAttribute("Kinds",Kinds);
		model.addAttribute("member",member);
		model.addAttribute("list",list);
	}

	//재능판매 목록 페이징
	@RequestMapping(value="/talentlistPage",method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get list page");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<Talent_S_VO> list=talentService.listPage(cri);
		model.addAttribute("member",member);
		model.addAttribute("list",list);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(talentService.listCount());
		model.addAttribute("pageMaker",pageMaker);
	}
	
	//글목록+페이징+검색
	@RequestMapping(value="/talentlistSearch", method=RequestMethod.GET)
	public void listSearch(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get list search");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		
		List<Talent_S_VO> list=talentService.listSearch(scri);
		model.addAttribute("member",member);
		model.addAttribute("list",list);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(talentService.listCount());
		model.addAttribute("pageMaker",pageMaker);		
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
}
