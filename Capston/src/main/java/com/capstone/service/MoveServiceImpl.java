package com.capstone.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.capstone.domain.Criteria;
import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;
import com.capstone.persistence.AdminDAO;
import com.capstone.persistence.MoveDAO;

@Service
public class MoveServiceImpl implements MoveService {

	@Inject
	private MoveDAO dao;
	
	//공지사항 출력
	@Override
	public List<NoticeVO> noticelist() throws Exception{
		return dao.noticelist();
	}
	
	//공지사항상세조회
	@Override
	public NoticeVO notice_View(int notice_Num) throws Exception{
		return dao.notice_View(notice_Num);
	}
	
	//1:1문의 등록
	@Override
	public void faq(FaqVO vo) throws Exception{
		dao.faq(vo);
	}
	
	//내가 등록한 판매 물품
	@Override
	public List<GoodsVO> goodslist(String seller_Id) throws Exception{
		return dao.goodslist(seller_Id);
	}
	
	//내가 요청한 거래들
	@Override
	public List<TradeVO> my_Trade_List(String goodsb_Id) throws Exception{
		return dao.my_Trade_List(goodsb_Id);
	}
	
	//등록된판매상품조회
	@Override
	public GoodsVO goodsView(int goods_Code) throws Exception {
		return dao.goodsView(goods_Code);
	}
	
	//거래조회
	@Override
	public TradeVO trade_view(int goods_Code)throws Exception{
		return dao.trade_view(goods_Code);
	}
		
	//후기 작성 완료
	@Override
	public void trade_com(TradeVO tv)throws Exception{
		dao.trade_com(tv);
	}
		
	
	//후기 작성
	@Override
	public void review_register(ReviewVO vo)throws Exception{
		dao.review_register(vo);
	}
	
	//후기 출력
	@Override
	public List<ReviewVO> reviewlist(String Id) throws Exception{
		return dao.reviewlist(Id);
	}
	
	//후기 삭제
	@Override
	public void reviewDelete(int review_Code) throws Exception{
		dao.reviewDelete(review_Code);
	}
		
	//후기 수정
	@Override
	public void reviewModify(ReviewVO vo) throws Exception{
		dao.reviewModify(vo);
	}
	
	//후기 조회
	@Override
	public ReviewVO reviewView(int review_Code) throws Exception{
		return dao.reviewView(review_Code);
	}

	//공지사항 추가
	@Override
	public void notice_register(NoticeVO vo) throws Exception {
		dao.notice_register(vo);
	}

	//공지사항 수정
	@Override
	public void noticeModify(NoticeVO vo) throws Exception {
		dao.noticeModify(vo);		
	}

	//공지사항 삭제
	@Override
	public void noticeDelete(int notice_Num) throws Exception {
		dao.noticeDelete(notice_Num);
	}

	//1:1문의 리스트
	@Override
	public List<FaqVO> faqlist() throws Exception {
		return dao.faqlist();
	}

	//1:1문의 자세히보기
	@Override
	public FaqVO faq_View(int faq_Code) throws Exception {
		return dao.faq_View(faq_Code);
	}

	//1:1문의 수정
	@Override
	public void faqModify(FaqVO vo) throws Exception {
		dao.faqModify(vo);
	}

	//1:1문의 삭제
	@Override
	public void faqDelete(int faq_Code) throws Exception {
		dao.faqDelete(faq_Code);
	}

	//회원리스트
	@Override
	public List<MemberVO> memberlist() throws Exception {
		return dao.memberlist();
	}

	//회원삭제
	@Override
	public void memberDelete(String Id) throws Exception {
		dao.memberDelete(Id);
	}

	//재능 판매 삭제
	@Override
	public void talentDelete(int Tals_Code) throws Exception {
		dao.talentDelete(Tals_Code);
	}

	//재능 판매 화면
	@Override
	public List<Talent_S_VO> talentSlist() throws Exception {
		return dao.talentSlist();
	}

	//재능 판매 상세 조회
	@Override
	public Talent_S_VO talentSview(int Tals_Code) throws Exception {
		return dao.talentSview(Tals_Code);
	}

	//관리자-판매상품 리스트
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return dao.goodslist();
	}

	//관리자-판매상품 삭제
	@Override
	public void goodsDelete(int goods_Code) throws Exception {
		dao.goodsDelete(goods_Code);
	}

	//목록+페이징
	@Override
	public List<NoticeVO> listPage(Criteria cri) throws Exception{
		return dao.listPage(cri);
	}
	
	//게시글 총 개수
	@Override
	public int listCount() throws Exception{
		return dao.listCount();
	}
	
	//목록+페이징+검색
	@Override
	public List<NoticeVO> listSearch(SearchCriteria scri) throws Exception {
		return dao.listSearch(scri);
	}

	//검색결과개수
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		return dao.countSearch(scri);
	}

	@Override
	public List<GoodsVO> goodslistPage(Criteria cri) throws Exception {
		return dao.goodslistPage(cri);
	}

	@Override
	public int goodslistCount() throws Exception {
		return dao.goodslistCount();
	}

	@Override
	public List<GoodsVO> goodslistSearch(SearchCriteria scri) throws Exception {
		return dao.goodslistSearch(scri);
	}

	@Override
	public int goodscountSearch(SearchCriteria scri) throws Exception {
		return dao.goodscountSearch(scri);
	}

	@Override
	public List<Talent_S_VO> talentlistPage(Criteria cri) throws Exception {
		return dao.talentlistPage(cri);
	}

	@Override
	public int talentlistCount() throws Exception {
		return dao.talentlistCount();
	}

	@Override
	public List<Talent_S_VO> talentlistSearch(SearchCriteria scri) throws Exception {
		return dao.talentlistSearch(scri);
	}

	@Override
	public int talentcountSearch(SearchCriteria scri) throws Exception {
		return dao.talentcountSearch(scri);
	}
}
