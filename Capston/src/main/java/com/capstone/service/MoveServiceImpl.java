package com.capstone.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.ReviewVO;
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
		
	//내가 구매희망 물품
	@Override
	public List<Goods_B_VO> goods_B_List(String goodsb_Id) throws Exception{
		return dao.goods_B_List(goodsb_Id);
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
}
