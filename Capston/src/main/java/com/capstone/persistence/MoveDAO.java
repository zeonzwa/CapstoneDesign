package com.capstone.persistence;

import java.util.List;

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.TradeVO;

public interface MoveDAO {

	//공지사항 출력
	public List<NoticeVO> noticelist() throws Exception;
	
	//공지사항상세조회
	public NoticeVO notice_View(int notice_Num) throws Exception;
	
	//1:1문의 등록
	public void faq(FaqVO vo) throws Exception;
	
	//내가 등록한 판매 물품
	public List<GoodsVO> goodslist(String seller_Id) throws Exception;
	
	//내가 등록한 구매희망 물품
	public List<Goods_B_VO> goods_B_List(String goodsb_Id) throws Exception;
	
	//내가 요청한 거래들
	public List<TradeVO> my_Trade_List(String goodsb_Id) throws Exception;
	
	//등록된 판매 상품 조회
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
