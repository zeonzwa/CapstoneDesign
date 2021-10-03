package com.capstone.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
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
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.PageMaker;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.TradeVO;
import com.capstone.service.AdminService;
import com.capstone.utils.UploadFileUtils;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
		
	@Resource(name="uploadPath")
	private String uploadPath;
	
	// 판매상품 등록 get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception {
		logger.info("get goods register");
	}
	
	// 판매상품 등록 post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo, TradeVO tv, MultipartFile file, HttpServletRequest req) throws Exception {
			
		String imgUploadPath = uploadPath + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload 
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);  // 위의 폴더를 기준으로 연월일 폴더를 생성
		String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
		HttpSession session = req.getSession();
		MemberVO seller = (MemberVO) session.getAttribute("member");
		vo.setSeller_Id(seller.getId());	
		vo.setPhone_Num(seller.getPhone_Num());
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
				// 파일 인풋박스에 첨부된 파일이 없다면(=첨부된 파일이 이름이 없다면)
				
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		
			// gdsImg에 원본 파일 경로 + 파일명 저장
			vo.setGoods_Pic(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				
		} else {  // 첨부된 파일이 없으면
			fileName = File.separator + "images" + File.separator + "none.png";
			// 미리 준비된 none.png파일을 대신 출력함
				
			vo.setGoods_Pic(fileName);
		}
			
			
			System.out.println("=================");
			
			System.out.println("1 = " + vo.getGoods_Name());
			System.out.println("1 = " + vo.getGoods_Price());
			System.out.println("1 = " + vo.getGoods_Des());
			System.out.println("1 = " + vo.getGoods_Pic());
			System.out.println("=================");
								
			adminService.register(vo);
			
			return "redirect:/admin/trade_list";
	}
	
	// 판매상품 수정 
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int goods_Code, Model model) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
			
		logger.info("get goods modify");
			
		GoodsVO goods = adminService.goodsView(goods_Code);  // GoodsVO형태 변수 goods에 상품 정보 저장
		model.addAttribute("goods", goods);
	}
		
	// 판매상품 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		logger.info("post modify");
		
		// 새로운 파일이 등록되었는지 확인
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			// 기존 파일을 삭제
			new File(uploadPath + req.getParameter("goods_Pic")).delete();
				
			// 새로 첨부한 파일을 등록
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGoods_Pic(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				
		} else {  // 새로운 파일이 등록되지 않았다면
			// 기존 이미지를 그대로 사용
			vo.setGoods_Pic(req.getParameter("goods_Pic"));
				
		}
		
		adminService.goodsModify(vo);
			
		return "redirect:/admin/trade_list";
	}
	// 판매상품 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int goods_Code) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
		
		logger.info("post goods delete");
		adminService.tradeDelete(goods_Code);
		adminService.goodsDelete(goods_Code);
			
		return "redirect:/admin/trade_list";
	}
	
	// 판매거래소 화면 출력
	@RequestMapping(value = "/trade_list", method = RequestMethod.GET)
	public void getGoodsList(Model model, HttpServletRequest req) throws Exception {
		logger.info("get trade_list");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<GoodsVO> list = adminService.goodslist();  // GoodsVO형태의 List형 변수 list 선언
		model.addAttribute("member", member);	
		model.addAttribute("list", list);  // 변수 list의 값을 list 세션에 부여
	}
	
	//판매거래소 페이징
	@RequestMapping(value="/tradelistPage",method=RequestMethod.GET)
	public void tradelistPage(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get list page");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<GoodsVO> list=adminService.listPage(cri);
		List<GoodsVO> list2=adminService.goodslist();
		model.addAttribute("member",member);
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.listCount());
		model.addAttribute("pageMaker",pageMaker);
	}
	
	//판매거래소 목록+페이징+검색
	@RequestMapping(value="/tradelistSearch",method=RequestMethod.GET)
	public void tradelistSearch(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
		logger.info("get list search");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<GoodsVO> list=adminService.goodslist();
		List<GoodsVO> list2=adminService.listSearch(scri);
		model.addAttribute("member",member);
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(adminService.listCount());
		model.addAttribute("pageMaker",pageMaker);
	}
		
	// 판매상품 상세 조회
	@RequestMapping(value = "/trade_view", method = RequestMethod.GET)
	public void getGoodsview(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req) throws Exception {
		logger.info("get goods view");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 	
		GoodsVO goods = adminService.goodsView(goods_Code);
		TradeVO trade = adminService.trade_view(goods_Code);
		List<ReviewVO> list = adminService.goodsReview(goods.getSeller_Id());
		if(trade==null) {
		adminService.trade_register(goods);//거래 테이블 값 넣기 시작
		model.addAttribute("goods", goods);
		model.addAttribute("member", member);
		model.addAttribute("list", list);
		}
		else {
		model.addAttribute("goods", goods);
		model.addAttribute("member", member);
		model.addAttribute("list", list);
		}
	}
	
////////////////여기까지 판매 상품 관련
	
	//구매 상품 등록 get
	@RequestMapping(value = "/goodsb_register", method = RequestMethod.GET)
	public void getGoodsBRegister(Model model) throws Exception {
		logger.info("get goodsb register");
	}
	//구매 상품 등록 post
	@RequestMapping(value = "/goodsb_register", method = RequestMethod.POST)
	public String postGoodsBRegister(Goods_B_VO vo, HttpServletRequest req) throws Exception {
			
		HttpSession session = req.getSession();
		MemberVO seller = (MemberVO) session.getAttribute("member");
		vo.setGoodsb_Id(seller.getId());			
		vo.setPhone_Num(seller.getPhone_Num());
		adminService.goods_B_Register(vo);
			
		return "redirect:/admin/goodsb_list";
	}
	//구매 상품 수정 get
	@RequestMapping(value = "/goodsb_modify", method = RequestMethod.GET)
	public void getGoodsBModify(@RequestParam("n") int goodsb_Code, Model model) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
			
		logger.info("get goodsb modify");
			
		Goods_B_VO goods = adminService.goods_B_View(goodsb_Code); // GoodsVO형태 변수 goods에 상품 정보 저장
		model.addAttribute("goods", goods);
	}
	//구매 상품 수정 post
	@RequestMapping(value = "/goodsb_modify", method = RequestMethod.POST)
	public String postGoodsBModify(Goods_B_VO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		logger.info("post goodsb_modify");
		
		adminService.goods_B_Modify(vo);
			
		return "redirect:/admin/goodsb_list";
	}
	//구매 상품 삭제
	@RequestMapping(value = "/goodsb_delete", method = RequestMethod.POST)
	public String postGoodsBDelete(@RequestParam("n") int goodsb_Code) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
		
		logger.info("post goodsb delete");
		adminService.goods_B_Delete(goodsb_Code);
			
		return "redirect:/admin/goodsb_list";
	}
	//구매 상품 화면 출력
	@RequestMapping(value = "/goodsb_list", method = RequestMethod.GET)
	public void getGoodsBList(Model model, HttpServletRequest req) throws Exception {
		logger.info("get goodsb_list");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<Goods_B_VO> list = adminService.goods_B_list();  // Goods_B_VO형태의 List형 변수 list 선언
		model.addAttribute("member", member);	
		model.addAttribute("list", list);  // 변수 list의 값을 list 세션에 부여
	}
	//구매 상품 상세 조회
	@RequestMapping(value = "/goodsb_view", method = RequestMethod.GET)
	public void getGoodsBview(@RequestParam("n") int goodsb_Code, Model model, HttpServletRequest req) throws Exception {
		logger.info("get goodsb view");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 	
		Goods_B_VO goods = adminService.goods_B_View(goodsb_Code);
		TradeVO trade = adminService.trade_view(goodsb_Code);
		model.addAttribute("goods", goods);
		model.addAttribute("member", member);
	}
	
	
////////////////여기까지 구매 상품 관련
	
	//거래 요청
	@RequestMapping(value = "/req", method = RequestMethod.POST)
	public String postTradeReq(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {
		logger.info("post trade request");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		TradeVO trade = adminService.trade_view(goods_Code);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(trade.getTrade_State()==1) {
		trade.setBuyer_Id(member.getId());
		trade.setTrade_State(2);
		out.println("<script language='javascript'>");
		out.println("alert('정상적으로 거래요청 되었습니다.');");
		out.println("</script>");
		out.flush();
		adminService.trade_req(trade);
		}
		else if(trade.getTrade_State()==2) {
			out.println("<script language='javascript'>");
			out.println("alert('해당 상품은 이미 거래가 진행중입니다.');");
			out.println("</script>");
			out.flush();
			
		}
		
		return "/move/index";
		
	}
	//거래 요청 취소
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String postTradeCancel(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {
		logger.info("post trade cancel");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		TradeVO trade = adminService.trade_view(goods_Code);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(member.getId().equals(trade.getBuyer_Id()) && trade.getTrade_State()==2) {
			String str="...";
			trade.setBuyer_Id(str);
			trade.setTrade_State(1);
			out.println("<script language='javascript'>");
			out.println("alert('정상적으로 거래요청취소 되었습니다.');");
			out.println("</script>");
			out.flush();
			adminService.trade_cancel(trade);
		}else {
			out.println("<script language='javascript'>");
			out.println("alert('거래요청한 상품이 아닙니다.');");
			out.println("</script>");
			out.flush();
		}
		return "/move/index";
		
	}
	//거래 완료
	@RequestMapping(value = "/complete", method = RequestMethod.POST)
	public String postTradeComplete(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {
		logger.info("post trade complete");
		TradeVO trade = adminService.trade_view(goods_Code);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(trade.getTrade_State()==2) {
			trade.setTrade_State(3);
			out.println("<script language='javascript'>");
			out.println("alert('정상적으로 거래완료 되었습니다.');");
			out.println("</script>");
			out.flush();
			adminService.trade_complete(trade);
			adminService.goods_set(goods_Code);
		}
		else if(trade.getTrade_State()==1) {
			out.println("<script language='javascript'>");
			out.println("alert('요청받은 거래가 없습니다.');");
			out.println("</script>");
			out.flush();
		}
		return "/move/index";
		
	}
	//거래 거부
	@RequestMapping(value = "/reject", method = RequestMethod.POST)
	public String postTradeReject(@RequestParam("n") int goods_Code, Model model, HttpServletResponse response) throws Exception {
		logger.info("post trade reject");
		TradeVO trade = adminService.trade_view(goods_Code);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(trade.getTrade_State()==2) {
			String str="...";
			trade.setBuyer_Id(str);
			trade.setTrade_State(1);
			out.println("<script language='javascript'>");
			out.println("alert('정상적으로 요청된 거래를 거부 하였습니다.');");
			out.println("</script>");
			out.flush();
			adminService.trade_cancel(trade);
		}
		else if(trade.getTrade_State()==1) {
			out.println("<script language='javascript'>");
			out.println("alert('요청받은 거래가 없습니다.');");
			out.println("</script>");
			out.flush();
		}
		
		return "/move/index";
		
	}
	
//////////여기 까지 상품 거래 관련

}
