package com.capstone.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.capstone.domain.Criteria;
import com.capstone.domain.Review_T_VO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;
import com.capstone.domain.Trade_T_VO;
import com.capstone.persistence.TalentDAO;

@Service
public class TalentServiceImpl implements TalentService{

	@Inject
	private TalentDAO dao;
	
	//재능 판매 등록
	@Override
	public void register(Talent_S_VO vo) throws Exception {
		dao.register(vo);
	}

	//재능 판매 수정
	@Override
	public void talentSModify(Talent_S_VO vo) throws Exception {
		dao.talentSModify(vo);
	}

	//재능 판매 삭제
	@Override
	public void talentDelete(int Tals_Code) throws Exception {
		dao.talentDelete(Tals_Code);
	}

	//재능 판매 목록(화면) 출력
	@Override
	public List<Talent_S_VO> talentSlist(String Kinds) throws Exception {
		return dao.talentSlist(Kinds);
	}
	
	//재능 판매 목록(화면) 소분류 출력
	@Override
	public List<Talent_S_VO> talentSlist_2(String Kinds) throws Exception {
		return dao.talentSlist_2(Kinds);
	}

	//재능 판매 상세 조회
	@Override
	public Talent_S_VO talentSview(int Tals_Code) throws Exception {
		return dao.talentSview(Tals_Code);
	}
	
	//재능 판매 상세 조회(후기 출력관련)
	@Override
	public List<Review_T_VO> talsReview(String tal_Id) throws Exception{
		return dao.talsReview(tal_Id);
	}
	
	//거래 조회
	@Override
	public Trade_T_VO trade_view(int trade_T_Code)throws Exception{
		return dao.trade_view(trade_T_Code);
	}
	
	//구매자 거래 요청 조회
	@Override
	public Trade_T_VO trade_view(String Buyer_Id)throws Exception{
		return dao.trade_view(Buyer_Id);
	}
	
	//거래 등록
	@Override
	public void trade_T_register(Trade_T_VO vo)throws Exception{
		dao.trade_T_register(vo);
	}
	
	//거래 완료
	@Override
	public void trade_T_complete(Trade_T_VO vo) throws Exception{
		dao.trade_T_complete(vo);
	}
	
	//거래 취소
	@Override
	public void trade_T_delete(int trade_T_Code)throws Exception{
		dao.trade_T_delete(trade_T_Code);
	}
	
	//목록+페이징
	@Override
	public List<Talent_S_VO> listPage(Criteria cri) throws Exception{
		return dao.listPage(cri);
	}
	
	//게시글 총 개수
	@Override
	public int listCount() throws Exception{
		return dao.listCount();
	}
	
	//목록+페이징+검색
	@Override
	public List<Talent_S_VO> listSearch(SearchCriteria scri) throws Exception {
		return dao.listSearch(scri);
	}

	//검색결과개수
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		return dao.countSearch(scri);
	}
}
