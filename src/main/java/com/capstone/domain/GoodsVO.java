package com.capstone.domain;

import java.util.Date;

public class GoodsVO {

	private int gdsNum;
	private String sellerId;
	private String gdsName;
	private String gdsCategory;
	private int gdsPrice;
	private int gdsSta;
	private String gdsDes;
	private String gdsImg;
	private Date gdsDate;
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public String getGdsCategory() {
		return gdsCategory;
	}
	public void setGdsCategory(String gdsCategory) {
		this.gdsCategory = gdsCategory;
	}
	public int getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public int getGdsSta() {
		return gdsSta;
	}
	public void setGdsSta(int gdsSta) {
		this.gdsSta = gdsSta;
	}
	public String getGdsDes() {
		return gdsDes;
	}
	public void setGdsDes(String gdsDes) {
		this.gdsDes = gdsDes;
	}
	public String getGdsImg() {
		return gdsImg;
	}
	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}
	public Date getGdsDate() {
		return gdsDate;
	}
	public void setGdsDate(Date gdsDate) {
		this.gdsDate = gdsDate;
	}
	
}
