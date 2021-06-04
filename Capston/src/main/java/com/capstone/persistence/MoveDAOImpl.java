package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.TradeVO;

@Repository
public class MoveDAOImpl implements MoveDAO {

	@Inject
	private SqlSession sql;
	// 매퍼 
	private static String namespace = "com.capstone.mappers.moveMapper";
	
	//공지사항 출력
	@Override
	public List<NoticeVO> noticelist() throws Exception{
		return sql.selectList(namespace + ".noticelist");
	}
	
	//공지사항상세조회
	@Override
	public NoticeVO notice_View(int notice_Num) throws Exception{
		return sql.selectOne(namespace + ".notice_View", notice_Num);
	}
	
	//1:1문의 등록
	@Override
	public void faq(FaqVO vo) throws Exception{
		sql.insert(namespace +".faq", vo);
	}
	
	//내가 등록한 판매 물품
	@Override
	public List<GoodsVO> goodslist(String seller_Id) throws Exception{
		return sql.selectList(namespace + ".goodslist", seller_Id);
	}
		
	//내가 등록한 구매희망 물품
	@Override
	public List<Goods_B_VO> goods_B_List(String goodsb_Id) throws Exception{
		return sql.selectList(namespace + ".goods_B_list", goodsb_Id);
	}
	
	//내가 요청한 거래들
	@Override
	public List<TradeVO> my_Trade_List(String goodsb_Id) throws Exception{
		return sql.selectList(namespace + ".my_Trade_List", goodsb_Id);
	}
	
	
	//등록된 판매 상품 조회
	@Override
	public GoodsVO goodsView(int goods_Code) throws Exception {
		return sql.selectOne(namespace + ".goodsView", goods_Code);
	}
	
	//거래조회
	@Override
	public TradeVO trade_view(int goods_Code)throws Exception{
		return sql.selectOne(namespace + ".tradeView", goods_Code);
	}
	
	//후기 작성 완료
	@Override
	public void trade_com(TradeVO tv)throws Exception{
		sql.update(namespace + ".trade_com", tv);
	}
	
	
	//후기 작성
	@Override
	public void review_register(ReviewVO vo)throws Exception{
		sql.insert(namespace + ".review_register", vo);
	}
	
	//후기 출력
	@Override
	public List<ReviewVO> reviewlist(String Id) throws Exception{
		return sql.selectList(namespace + ".reviewlist",Id);
	}
	
	//후기 삭제
	@Override
	public void reviewDelete(int review_Code) throws Exception{
		sql.delete(namespace + ".reviewDelete", review_Code);
	}
		
	//후기 수정
	@Override
	public void reviewModify(ReviewVO vo) throws Exception{
		sql.update(namespace + ".reviewModify", vo);
	}
	
	//후기 조회
	@Override
	public ReviewVO reviewView(int review_Code) throws Exception{
		return sql.selectOne(namespace + ".reviewView", review_Code);
	}
}
