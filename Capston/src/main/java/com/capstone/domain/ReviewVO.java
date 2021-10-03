package com.capstone.domain;

import java.util.Date;

public class ReviewVO {
	
	private String review_Code;		//넣어야 되는 값 : 거래 코드
	private String review_Content;
	private int review_Sta;
	private String review_Writer;
	private Date review_Date;
	private String review_Goods;
	private String review_Trader;
	
	public String getReview_Code() {
		return review_Code;
	}
	public void setReview_Code(String review_Code) {
		this.review_Code = review_Code;
	}
	public String getReview_Content() {
		return review_Content;
	}
	public void setReview_Content(String review_Content) {
		this.review_Content = review_Content;
	}
	
	public int getReview_Sta() {
		return review_Sta;
	}
	public void setReview_Sta(int review_Sta) {
		this.review_Sta = review_Sta;
	}
	public String getReview_Writer() {
		return review_Writer;
	}
	public void setReview_Writer(String review_Writer) {
		this.review_Writer = review_Writer;
	}
	public Date getReview_Date() {
		return review_Date;
	}
	public void setReview_Date(Date review_Date) {
		this.review_Date = review_Date;
	}
	public String getReview_Goods() {
		return review_Goods;
	}
	public void setReview_Goods(String review_Goods) {
		this.review_Goods = review_Goods;
	}
	public String getReview_Trader() {
		return review_Trader;
	}
	public void setReview_Trader(String review_Trader) {
		this.review_Trader = review_Trader;
	}
	
	
}