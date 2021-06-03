package com.capstone.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Inject
	private SqlSession sql;
	// 매퍼 
	private static String namespace = "com.capstone.mappers.reviewMapper";
	
	//후기 작성
	
	
	//후기 수정
	
	
	//후기 삭제
	
	
	//후기 관리 화면 출력
	
	
	//상품상세 대한 후기 출력
}
