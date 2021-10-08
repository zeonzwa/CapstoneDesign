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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.domain.Criteria;
import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.PageMaker;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.Talent_S_VO;
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
	
	//메인화면 post
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String postIndex(MemberVO vo) throws Exception {
		 
		return "move/index";
	}
	
	//관리자 get
	@RequestMapping(value="/manager",method=RequestMethod.GET)
	public void getManager(Model model, HttpServletRequest req) throws Exception{
		logger.info("get manager");
		List<NoticeVO> list=moveService.noticelist();
		model.addAttribute("list",list);
	}
	
	//괸라자 상세조회
	@RequestMapping(value="/manager_view",method=RequestMethod.GET)
	public void getManagerview(@RequestParam("n") int notice_Num, Model model, HttpServletRequest req) throws Exception{
		logger.info("get manager view");
		HttpSession session=req.getSession();
		NoticeVO notice=moveService.notice_View(notice_Num);
		model.addAttribute("notice",notice);
	}
	
	//관리자 공지사항 글쓰기 get
	@RequestMapping(value="/manager_register", method=RequestMethod.GET)
	public void getManagerRegister(Model model) throws Exception{
		logger.info("get manager register");
	}
	
	//관리자 공지사항 글쓰기 post
	@RequestMapping(value="/manager_register", method=RequestMethod.POST)
	public String postManagerRegister(NoticeVO vo, HttpServletRequest req) throws Exception{
		HttpSession session=req.getSession();
		MemberVO manager=(MemberVO) session.getAttribute("member");
		moveService.notice_register(vo);
		return "redirect:/move/manager";
		
	}
	
	//관리자 공지사항 수정  get
	@RequestMapping(value="/manager_modify",method=RequestMethod.GET)
	public void getManagerModify(@RequestParam("n") int notice_Num, Model model) throws Exception{
		logger.info("get manager modify");		
		NoticeVO notice=moveService.notice_View(notice_Num);
		model.addAttribute("notice",notice);
	}
	
	//관리자 공지사항 수정 post
	@RequestMapping(value="/manager_modify",method=RequestMethod.POST)
	public String postManagerModify(NoticeVO vo, HttpServletRequest req) throws Exception{
		logger.info("post manager modify");
		moveService.noticeModify(vo);
		return "redirect:/move/manager";
	}
	
	//관리자 공지사항 삭제
	@RequestMapping(value="/manager_delete", method=RequestMethod.POST)
	public String postManagerDelete(@RequestParam("n") int notice_Num) throws Exception{
		logger.info("post manager delete");
		moveService.noticeDelete(notice_Num);
		
		return "redirect:/move/manager";
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
	
	//공지사항 페이징
	@RequestMapping(value="/contactlistPage",method=RequestMethod.GET)
	public void contactlistPage(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get contactlist page");
		HttpSession session = req.getSession();
		List<NoticeVO> list=moveService.listPage(cri);
		model.addAttribute("list",list);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(moveService.listCount());
		model.addAttribute("pageMaker",pageMaker);
	}
	
	//공지사항_페이징_검색
	@RequestMapping(value="/contactlistSearch",method=RequestMethod.GET)
	public void contactlistSearch(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get contactsearch");
		HttpSession session = req.getSession();
		List<NoticeVO> list=moveService.listSearch(scri);
		model.addAttribute("list",list);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(moveService.listCount());
		model.addAttribute("pageMaker",pageMaker);
	}
	
	//관리자공지사항 페이징
	@RequestMapping(value="/managerlistPage",method=RequestMethod.GET)
	public void managerlistPage(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get contactlist page");
		HttpSession session = req.getSession();
		List<NoticeVO> list=moveService.listPage(cri);
		model.addAttribute("list",list);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(moveService.listCount());
		model.addAttribute("pageMaker",pageMaker);
	}
	
	//관리자공지사항_페이징_검색
	@RequestMapping(value="/managerlistSearch",method=RequestMethod.GET)
	public void managerlistSearch(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get contactsearch");
		HttpSession session = req.getSession();
		List<NoticeVO> list=moveService.listSearch(scri);
		model.addAttribute("list",list);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(moveService.listCount());
		model.addAttribute("pageMaker",pageMaker);
	}
	
	
	//관리자-재능 판매 화면 출력
	@RequestMapping(value="/manager_talent_S", method=RequestMethod.GET)
	public void getManagerTalentList(Model model, HttpServletRequest req) throws Exception{
		logger.info("get manager_S");
		HttpSession session=req.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		List<Talent_S_VO>list=moveService.talentSlist();
		model.addAttribute("member",member);
		model.addAttribute("list",list);
	}
	
	//관리자-재능 판매 화면 상세 조회
	@RequestMapping(value="/manager_talent_S_view", method=RequestMethod.GET)
	public void getManagerTalentView(@RequestParam("n") int Tals_Code, Model model, HttpServletRequest req) throws Exception{
		logger.info("get manager_S view");
		HttpSession session=req.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		Talent_S_VO talent=moveService.talentSview(Tals_Code);
		model.addAttribute("talent",talent);
		model.addAttribute("member",member);
	}
	
	//관리자-재능 판매 삭제
	@RequestMapping(value="/manager_talent_S_delete",method=RequestMethod.GET)
	public String postManagerTalentDelete(@RequestParam("n") int tals_Code) throws Exception{
		logger.info("post manager_talent delete");
		moveService.talentDelete(tals_Code);
		
		return "redirect:/move/managertalentlistPage";
	}
	
	//관리자-판매상품 삭제
	@RequestMapping(value="/manager_sell_delete",method=RequestMethod.GET)
	public String postManagerGoodsDelete(@RequestParam("n") int goods_Code) throws Exception{
		logger.info("post manager goods delete");
		moveService.goodsDelete(goods_Code);
		
		return "redirect:/move/manager_sell";
	}
	
	//관리자-판매상품 리스트
	@RequestMapping(value="/manager_sell",method=RequestMethod.GET)
	public void getManagerGoodsList(Model model, HttpServletRequest req) throws Exception{
		logger.info("get manager goods list");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<GoodsVO> list=moveService.goodslist();
		model.addAttribute("member", member);
		model.addAttribute("list", list);
	}
	
	//관리자-판매상품 상세조회
	@RequestMapping(value="/manager_sell_view", method=RequestMethod.GET)
	public void getManagerGoodsView(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req) throws Exception{
		logger.info("get manager goods view");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		GoodsVO goods = moveService.goodsView(goods_Code);
		TradeVO trade = moveService.trade_view(goods_Code);
	}
	
	//관리자-판매상품 페이징
	@RequestMapping(value="managerSelllistPage",method=RequestMethod.GET)
	public void managerSelllistPage(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get manager sell list page");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<GoodsVO> list=moveService.goodslistPage(cri);
		List<GoodsVO> list2=moveService.goodslist();
		model.addAttribute("member",member);
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(moveService.goodslistCount());
		model.addAttribute("pageMaker",pageMaker);
	}
	
	//관리자-판매상품 목록+페이징+검색
	@RequestMapping(value="managerSelllistSearch",method=RequestMethod.GET)
	public void managerSelllistSearch(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get maanger sell list Search");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<GoodsVO> list=moveService.goodslist();
		List<GoodsVO> list2=moveService.goodslistSearch(scri);
		model.addAttribute("member",member);
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(moveService.goodslistCount());
		model.addAttribute("pageMaker",pageMaker);
	}
	
	//관리자 재능판매 목록 페이징
	@RequestMapping(value="/managertalentlistPage",method=RequestMethod.GET)
	public void managertalentlistPage(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get manager list page");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<Talent_S_VO> list=moveService.talentlistPage(cri);
		model.addAttribute("member",member);
		model.addAttribute("list",list);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(moveService.talentlistCount());
		model.addAttribute("pageMaker",pageMaker);
	}
	
	//관리자 재능판매 목록 페이징+검색
	@RequestMapping(value="/managertalentlistSearch", method=RequestMethod.GET)
	public void managertalentlistSearch(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get manager talent list Search");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		
		List<Talent_S_VO> list=moveService.talentlistSearch(scri);
		model.addAttribute("member",member);
		model.addAttribute("list",list);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(moveService.talentlistCount());
		model.addAttribute("pageMaker",pageMaker);	
	}
	
	//등록한 판매, 구매 물품 목록 get
	@RequestMapping(value = "/uploaded", method = RequestMethod.GET)
	public void getUploaded(Model model, HttpServletRequest req) throws Exception {
		logger.info("get uploaded");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<GoodsVO> list = moveService.goodslist(member.getId());
		model.addAttribute("member", member);	
		model.addAttribute("list", list);
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
	
	//1:1문의 리스트
	@RequestMapping(value="/manager_faq", method=RequestMethod.GET)
	public void getFaqList(Model model, HttpServletRequest req) throws Exception{
		logger.info("get faq list");
		List<FaqVO> list=moveService.faqlist();
		model.addAttribute("list",list);
	}
	
	//1:1문의 자세히보기
	@RequestMapping(value="/manager_faq_view", method=RequestMethod.GET)
	public void getFaqView(@RequestParam("n") int faq_Code, Model model, HttpServletRequest req) throws Exception{
		logger.info("get faq view");
		HttpSession session=req.getSession();
		FaqVO faq=moveService.faq_View(faq_Code);
		model.addAttribute("faq",faq);
	}
	
	//1:1문의 삭제
	@RequestMapping(value="/manager_faq_delete", method=RequestMethod.GET)
	public String postFaqDelete(@RequestParam("n") int faq_Code) throws Exception{
		logger.info("post faq delete");
		moveService.faqDelete(faq_Code);
		return "redirect:/move/manager";
	}
	
	//회원리스트
	@RequestMapping(value="/contact_member", method=RequestMethod.GET)
	public void getMemberList(Model model, HttpServletRequest req) throws Exception{
		logger.info("get memberlist");
		List<MemberVO> list=moveService.memberlist();
		model.addAttribute("list",list);
	}
	
	//회원삭제
	@RequestMapping(value="/contact_member_delete", method=RequestMethod.GET)
	public String postMemberDelete(@RequestParam("n") String Id) throws Exception{
		logger.info("post delete member");
		moveService.memberDelete(Id);
		return "redirect:/move/contact";
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
