package com.capstone.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.Talent_B_VO;
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
		
		talentService.talentSModify(vo);
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
	@RequestMapping(value = "/talent_B_register", method = RequestMethod.GET)
	public void getTalentBRegister(Model model) throws Exception {
		logger.info("get talentb register");
	}
	//재능 구매 등록 post
	@RequestMapping(value = "/talent_B_register", method = RequestMethod.POST)
	public String postTalentBRegister(Talent_B_VO vo, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		MemberVO buyer = (MemberVO) session.getAttribute("member");
		vo.setTalb_Id(buyer.getId());			
		vo.setPhone_Num(buyer.getPhone_Num());
		talentService.talent_B_Register(vo);
			
		return "redirect:/talent/talent_B_list";
	}	
		
	//재능 구매 수정 get
	@RequestMapping(value = "/talent_B_modify", method = RequestMethod.GET)
	public void getTalentBModify(@RequestParam("n") int talb_Code, Model model) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
			
		logger.info("get talb modify");
			
		Talent_B_VO talent = talentService.talent_B_View(talb_Code); // GoodsVO형태 변수 goods에 상품 정보 저장
		model.addAttribute("talent", talent);
	}	
		
	//재능 구매 수정 post
	@RequestMapping(value = "/talent_B_modify", method = RequestMethod.POST)
	public String postGoodsBModify(Talent_B_VO vo, HttpServletRequest req) throws Exception {
		logger.info("post talb_modify");
		
		talentService.talent_B_Modify(vo);
			
		return "redirect:/talent/talent_B_list";
	}	
	
	//재능 구매 삭제
	@RequestMapping(value = "/talent_B_delete", method = RequestMethod.POST)
	public String posttalentBDelete(@RequestParam("n") int talb_Code) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
		
		logger.info("post talb delete");
		talentService.talent_B_Delete(talb_Code);
			
		return "redirect:/talent/talent_B_list";
	}	
		
	//재능 구매 화면 출력
	@RequestMapping(value = "/talent_B_list", method = RequestMethod.GET)
	public void gettalentBList(Model model, HttpServletRequest req) throws Exception {
		logger.info("get talb_list");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<Talent_B_VO> list = talentService.talent_B_list();  // Goods_B_VO형태의 List형 변수 list 선언
		model.addAttribute("member", member);	
		model.addAttribute("list", list);  // 변수 list의 값을 list 세션에 부여
	}	
	//재능 구매 상세 조회
	@RequestMapping(value = "/talent_B_view", method = RequestMethod.GET)
	public void getTalentBview(@RequestParam("n") int talb_Code, Model model, HttpServletRequest req) throws Exception {
		logger.info("get talb view");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 	
		Talent_B_VO talent = talentService.talent_B_View(talb_Code);
		model.addAttribute("talent", talent);
		model.addAttribute("member", member);
	}
//////////////여기까지 재능 구매 관련
	
	
	
	
	
	
	
	
	
}
