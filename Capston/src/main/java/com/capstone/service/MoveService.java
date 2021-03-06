package com.capstone.service;

import java.util.List;

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.Talent_B_VO;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;

public interface MoveService {
	
	//공지사항 추가
	public void notice_register(NoticeVO vo) throws Exception;
	
	//공지사항 수정
	public void noticeModify(NoticeVO vo) throws Exception;
	
	//공지사항 삭제
	public void noticeDelete(int notice_Num) throws Exception;

	//공지사항
	public List<NoticeVO> noticelist() throws Exception;
	
	//공지사항상세조회
	public NoticeVO notice_View(int notice_Num) throws Exception;
	
	//1:1문의 등록
	public void faq(FaqVO vo) throws Exception;
	
	//1:1문의 리스트
	public List<FaqVO> faqlist() throws Exception;
	
	//1:1문의 자세히보기
	public FaqVO faq_View(int faq_Code) throws Exception;
	
	//1:1문의 수정
	public void faqModify(FaqVO vo) throws Exception;
	
	//1:1문의 삭제
	public void faqDelete(int faq_Code) throws Exception;
	
	//회원리스트
	public List<MemberVO> memberlist() throws Exception;
	
	//회원삭제
	public void memberDelete(String Id) throws Exception;
	
	//재능 판매 삭제
	public void talentDelete(int Tals_Code) throws Exception;
		
	//재능 판매 목록(화면) 출력
	public List<Talent_S_VO> talentSlist() throws Exception;
		
	//재능 판매 상세 조회
	public Talent_S_VO talentSview(int Tals_Code) throws Exception;
		
	
	//재능 구매 삭제
	public void talent_B_Delete(int talb_Code) throws Exception;
	
	//재능 구매 목록(화면) 출력
	public List<Talent_B_VO> talent_B_list() throws Exception;
	
	//재능 구매 상세 조회
	public Talent_B_VO talent_B_View(int talb_Code) throws Exception;
	
	//내가 등록한 판매 물품
	public List<GoodsVO> goodslist(String seller_Id) throws Exception;
		
	//내가 등록한 구매희망 물품
	public List<Goods_B_VO> goods_B_List(String goodsb_Id) throws Exception;
	
	//내가 요청한 거래들
	public List<TradeVO> my_Trade_List(String goodsb_Id) throws Exception;
	
	//등록된판매상품조회
	public GoodsVO goodsView(int goods_Code) throws Exception;
	
	//거래조회
	public TradeVO trade_view(int goods_Code)throws Exception;
		
	//후기 작성 완료
	public void trade_com(TradeVO tv)throws Exception;
		
	//후기 작성
	public void review_register(ReviewVO vo)throws Exception;
	
	//후기 출력
	public List<ReviewVO> reviewlist(String Id) throws Exception;
	
	//후기 삭제
	public void reviewDelete(int review_Code) throws Exception;
		
	//후기 수정
	public void reviewModify(ReviewVO vo) throws Exception;
	
	//후기 조회
	public ReviewVO reviewView(int review_Code) throws Exception;
}
