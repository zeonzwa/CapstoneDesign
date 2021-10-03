package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.Criteria;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	private SqlSession sql;
	// 매퍼 
	private static String namespace = "com.capstone.mappers.adminMapper";

	
	//판매상품등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}
	//판매상품목록(화면)출력
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return sql.selectList(namespace + ".goodslist");
	
	}
	//판매상품상세조회
	@Override
	public GoodsVO goodsView(int goods_Code) throws Exception {
		return sql.selectOne(namespace + ".goodsView", goods_Code);
	}
	
	//판매상품조회(후기 출력관련)
	@Override
	public List<ReviewVO> goodsReview(String goods_Id) throws Exception{
		return sql.selectList(namespace + ".goodsReview", goods_Id);
	}

	//판매 상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update(namespace + ".goodsModify", vo);
	}

	//판매상품 삭제
	@Override
	public void goodsDelete(int goods_Code) throws Exception {
		sql.delete(namespace + ".goodsDelete", goods_Code);
	}
	
	//구매상품등록
	@Override
	public void goods_B_Register(Goods_B_VO vo) throws Exception{
		sql.insert(namespace + ".goods_B_Register", vo);
	}
	//구매상품수정
	@Override
	public void goods_B_Modify(Goods_B_VO vo) throws Exception{
		sql.update(namespace + ".goods_B_Modify", vo);
	}
	//구매상품삭제
	@Override
	public void goods_B_Delete(int goods_B_Code) throws Exception{
		sql.delete(namespace + ".goods_B_Delete", goods_B_Code);
	}
	//구매상품목록(화면)출력
	@Override
	public List<Goods_B_VO> goods_B_list() throws Exception{
		return sql.selectList(namespace + ".goods_B_list");
	}
	//구매상품상세조회
	@Override
	public Goods_B_VO goods_B_View(int goods_B_Code) throws Exception{
		return sql.selectOne(namespace + ".goods_B_View", goods_B_Code);
	}
	//거래등록
	@Override
	public void trade_register(GoodsVO vo)throws Exception{
		sql.insert(namespace + ".trade_register",vo);
	}
	
	//거래조회
	@Override
	public TradeVO trade_view(int goods_Code) throws Exception{
		return sql.selectOne(namespace + ".trade_view", goods_Code);
	}
	
	//거래요청
	@Override
	public void trade_req(TradeVO tv)throws Exception{
		sql.update(namespace + ".trade_req",tv);
	}
	
	//거래요청 취소 및 거부
	@Override
	public void trade_cancel(TradeVO tv)throws Exception{
		sql.update(namespace + ".trade_cancel",tv);
	}
	//거래 완료
	@Override
	public void trade_complete(TradeVO tv)throws Exception{
		sql.update(namespace + ".trade_complete",tv);
	}
	
	//거래 완료후 상품 상태 2번으로 승격
	@Override
	public void goods_set(int goods_Code)throws Exception{
		sql.update(namespace + ".goods_set", goods_Code);
	}
	
	//거래 삭제
	@Override
	public void tradeDelete(int goods_Code) throws Exception {
		sql.delete(namespace+ ".tradeDelete", goods_Code);
	}
	
	//목록+페이징
	@Override
	public List<GoodsVO> listPage(Criteria cri) throws Exception{
		return sql.selectList(namespace+".listPage",cri);
	}
	
	//게시글 총 개수
	@Override
	public int listCount() throws Exception{
		return sql.selectOne(namespace+".listCount");
	}
	
	//목록+페이징+검색
	@Override
	public List<GoodsVO> listSearch(SearchCriteria scri) throws Exception {
		return sql.selectList(namespace+".listSearch",scri);
	}

	//검색 결과 개수
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		return sql.selectOne(namespace+".countSearch",scri);
	}

}
