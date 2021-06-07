package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.Talent_B_VO;
import com.capstone.domain.Talent_S_VO;

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
	public List<Talent_S_VO> talentSlist() throws Exception {
		return sql.selectList(namespace + ".talentSlist");
	}
	
	//재능 판매 상세 조회
	@Override
	public Talent_S_VO talentSview(int Tals_Code) throws Exception {
		return sql.selectOne(namespace + ".talentSview", Tals_Code);
	}
		
	//재능 구매 등록
	@Override
	public void talent_B_Register(Talent_B_VO vo) throws Exception{
		sql.insert(namespace + ".talent_B_Register", vo);
	}
	//재능 구매 수정
	@Override
	public void talent_B_Modify(Talent_B_VO vo) throws Exception{
		sql.update(namespace + ".talent_B_Modify", vo);
	}
	//재능 구매 삭제
	@Override
	public void talent_B_Delete(int talb_Code) throws Exception{
		sql.delete(namespace + ".talent_B_Delete", talb_Code);
	}
	//재능 구매 목록(화면) 출력
	@Override
	public List<Talent_B_VO> talent_B_list() throws Exception{
		return sql.selectList(namespace + ".talent_B_list");
	}
	//재능 구매 상세 조회
	@Override
	public Talent_B_VO talent_B_View(int talb_Code) throws Exception{
		return sql.selectOne(namespace + ".talent_B_View", talb_Code);
	}
}
