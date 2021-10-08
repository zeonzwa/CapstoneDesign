package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.Criteria;
import com.capstone.domain.Review_T_VO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;
import com.capstone.domain.Trade_T_VO;

@Repository
public class TalentDAOImpl implements TalentDAO{

	@Inject
	private SqlSession sql;
	// 매퍼 
	private static String namespace = "com.capstone.mappers.talentMapper";
	
	//재능 판매 등록
	@Override
	public void register(Talent_S_VO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}
	
	//재능 판매 수정
	@Override
	public void talentSModify(Talent_S_VO vo) throws Exception {
		sql.update(namespace + ".talentModify", vo);
	}
	
	//재능 판매 삭제
	@Override
	public void talentDelete(int Tals_Code) throws Exception {
		sql.delete(namespace + ".talentDelete", Tals_Code);
		
	}
	
	//재능 판매 목록(화면) 출력
	@Override
	public List<Talent_S_VO> talentSlist(String Kinds) throws Exception {
		return sql.selectList(namespace + ".talentSlist",Kinds);
	}
	
	//재능 판매 목록(화면) 소분류 출력
	@Override
	public List<Talent_S_VO> talentSlist_2(String Kinds) throws Exception {
		return sql.selectList(namespace + ".talentSlist_2", Kinds);
	}
	
	//재능 판매 상세 조회
	@Override
	public Talent_S_VO talentSview(int Tals_Code) throws Exception {
		return sql.selectOne(namespace + ".talentSview", Tals_Code);
	}
	
	//재능 판매 상세 조회(후기 출력관련)
	@Override
	public List<Review_T_VO> talsReview(String tal_Id) throws Exception{
		return sql.selectList(namespace+".talsReview", tal_Id);
	}
	
	//거래 조회
	@Override
	public Trade_T_VO trade_view(int trade_T_Code)throws Exception{
		return sql.selectOne(namespace + ".trade_view", trade_T_Code);
	}
	
	//구매자 거래 요청 조회
	@Override
	public Trade_T_VO trade_view(String Buyer_Id)throws Exception{
		return sql.selectOne(namespace+ ".trade_view_2", Buyer_Id);
	}
	
	//거래 등록
	@Override
	public void trade_T_register(Trade_T_VO vo)throws Exception{
		sql.insert(namespace+".trade_t_register",vo);
	}
	
	//거래 완료
	@Override
	public void trade_T_complete(Trade_T_VO vo) throws Exception{
		sql.update(namespace+".trade_t_complete", vo);
	}
	
	//거래 취소
	@Override
	public void trade_T_delete(int trade_T_Code)throws Exception{
		sql.delete(namespace+ ".trade_t_delete", trade_T_Code);
	}
	
	//목록+페이징
	@Override
	public List<Talent_S_VO> listPage(Criteria cri) throws Exception{
		return sql.selectList(namespace+".listPage",cri);
	}
	
	//게시글 총 개수
	@Override
	public int listCount() throws Exception{
		return sql.selectOne(namespace+".listCount");
	}
	
	//목록+페이징+검색
	@Override
	public List<Talent_S_VO> listSearch(SearchCriteria scri) throws Exception {
		return sql.selectList(namespace+".listSearch",scri);
	}

	//검색 결과 개수
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		return sql.selectOne(namespace+".countSearch",scri);
	}
}
