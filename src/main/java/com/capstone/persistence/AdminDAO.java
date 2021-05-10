package com.capstone.persistence;

import java.util.List;

import com.capstone.domain.GoodsVO;

public interface AdminDAO {

		// 상품등록
		public void register(GoodsVO vo) throws Exception;
		
		// 상품목록
		public List<GoodsVO> goodslist() throws Exception;
		 
		// 상품조회
		public GoodsVO goodsView(int gdsNum) throws Exception;
		
		// 상품 수정
		public void goodsModify(GoodsVO vo) throws Exception;
		
		// 상품 삭제
		public void goodsDelete(int gdsNum) throws Exception;
}
