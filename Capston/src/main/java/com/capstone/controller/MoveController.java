package com.capstone.controller;

import java.io.File;
import java.util.ArrayList;
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

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.TradeVO;
import com.capstone.service.AdminService;
import com.capstone.service.MoveService;
import com.capstone.utils.UploadFileUtils;

@Controller
@RequestMapping("/move/*")
public class MoveController {

	private static final Logger logger = LoggerFactory.getLogger(MoveController.class);
	
	@Inject
	MoveService moveService;
	//메인화면 get
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index");
	}
	
	// 메인화면 post
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String postIndex(MemberVO vo) throws Exception {
		 
		return "move/index";
	}
	//공지사항 get
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public void getContact(Model model, HttpServletRequest req ) throws Exception {
		logger.info("get contact list");
		List<NoticeVO> list = moveService.noticelist();
		model.addAttribute("list", list);
	}
	
	// 공지사항 상세 조회
	@RequestMapping(value = "/contact_view", method = RequestMethod.GET)
	public void getGoodsview(@RequestParam("n") int notice_Num, Model model, HttpServletRequest req) throws Exception {
		logger.info("get notice view");
		HttpSession session = req.getSession(); 	
		NoticeVO notice = moveService.notice_View(notice_Num);
		model.addAttribute("notice", notice);
	}
	
	
	//등록한 판매, 구매 물품 목록 get
	@RequestMapping(value = "/uploaded", method = RequestMethod.GET)
	public void getUploaded(Model model, HttpServletRequest req) throws Exception {
		logger.info("get uploaded");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<GoodsVO> list = moveService.goodslist(member.getId());
		List<Goods_B_VO> list2 = moveService.goods_B_List(member.getId());
		model.addAttribute("member", member);	
		model.addAttribute("list", list); 
		model.addAttribute("list2", list2);
	}
	
	
	//거래요청한 거래 목록 get
	@RequestMapping(value = "/wantbuy", method = RequestMethod.GET)
	public void getWantBuy(Model model, HttpServletRequest req) throws Exception {
		logger.info("get wantbuy");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<TradeVO>list = moveService.my_Trade_List(member.getId());
		List<GoodsVO> list2 = new ArrayList();
		for(TradeVO e : list) {
			if(e.getTrade_State()==2) {
			GoodsVO res = moveService.goodsView(e.getGoods_Code());
			list2.add(res);
			}
		}
		model.addAttribute("member", member);	
		model.addAttribute("list", list2);
	}
	//거래 완료한 거래 목록 get
	@RequestMapping(value = "/trade_complete", method = RequestMethod.GET)
	public void getTrade_Complete(Model model, HttpServletRequest req) throws Exception {
		logger.info("get complete");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<TradeVO>list = moveService.my_Trade_List(member.getId());
		List<GoodsVO> list2 = new ArrayList();
		for(TradeVO e : list) {
			if(e.getTrade_State()==3) {
			GoodsVO res = moveService.goodsView(e.getGoods_Code());
			list2.add(res);
			}
		}
		model.addAttribute("member", member);	
		model.addAttribute("list", list2);
	}
	
	// 후기작성 get
	@RequestMapping(value = "/review_reg", method = RequestMethod.GET)
	public void getReviewReg(@RequestParam("n") int goods_Code, Model model , HttpServletRequest req) throws Exception {
		logger.info("get review register");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		GoodsVO res = moveService.goodsView(goods_Code);
		model.addAttribute("goods", res);
	}
	//후기 작성 post
	@RequestMapping(value = "/review_reg", method = RequestMethod.POST)
	public String postReviewReg(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req, ReviewVO vo) throws Exception {
		logger.info("post review register");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		GoodsVO res = moveService.goodsView(goods_Code);
		vo.setReview_Writer(member.getId());
		vo.setReview_Trader(res.getSeller_Id());
		vo.setReview_Goods(res.getGoods_Name());
		
		moveService.review_register(vo);
		
		TradeVO trade = moveService.trade_view(goods_Code);
		trade.setTrade_State(4);
		moveService.trade_com(trade);
		
		return "redirect:/move/review";
		
	}
	
	//후기 출력
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public void getReviewList(Model model, HttpServletRequest req) throws Exception {
		logger.info("get review_list");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<ReviewVO> list = moveService.reviewlist(member.getId());  // GoodsVO형태의 List형 변수 list 선언
		model.addAttribute("member", member);	
		model.addAttribute("list", list);  // 변수 list의 값을 list 세션에 부여
	}

	//후기 삭제
	@RequestMapping(value = "/review_delete", method = RequestMethod.GET)
	public String postReviewDelete(@RequestParam("n") int review_Code) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
			
		logger.info("post review delete");
		moveService.reviewDelete(review_Code);
				
		return "redirect:/move/review";
	}
	//후기 수정 
	@RequestMapping(value = "/review_modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int review_Code, Model model) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
				
		logger.info("get review modify");
		
		ReviewVO review = moveService.reviewView(review_Code);  // ReviewVO형태 변수 review에 후기 정보 저장
		model.addAttribute("review", review);
		System.out.println(review_Code);
	}
	// 후기 수정
	@RequestMapping(value = "/review_modify", method = RequestMethod.POST)
	public String postGoodsModify(ReviewVO vo, HttpServletRequest req) throws Exception {
		logger.info("post review modify");
		System.out.println(vo.getReview_Code());
		moveService.reviewModify(vo);
			
		return "redirect:/move/review";
	}
	
	//1:1문의 get
	@RequestMapping(value = "/faq2", method = RequestMethod.GET)
	public void getfaq2() throws Exception {
		logger.info("get faq2");
	}
	
	//1:1문의 post
	@RequestMapping(value = "/faq2", method = RequestMethod.POST)
	public String postfaq2(FaqVO vo, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		MemberVO seller = (MemberVO) session.getAttribute("member");
		vo.setFaq_Id(seller.getId());
		moveService.faq(vo);
		return "redirect:/move/index";
	}
	
	//질문 get
	@RequestMapping(value = "/faq1", method = RequestMethod.GET)
	public void getfaq1() throws Exception {
		logger.info("get faq1");
	}
	
	// 질문 post
	@RequestMapping(value = "/faq1", method = RequestMethod.POST)
	public String postfaq1(MemberVO vo) throws Exception {
		return "move/faq1";
	}
}
