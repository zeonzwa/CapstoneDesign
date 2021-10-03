package com.capstone.domain;

import java.util.Date;

public class GoodsVO {

	private int goods_Code;
	private String seller_Id;
	private String goods_Name;
	private String goods_Cate;
	private int goods_Price;
	private int goods_Sta;
	private String goods_Des;
	private String goods_Pic;
	private Date goods_Date;
	private String phone_Num;
	private String goods_State;
	
	
	public String getGoods_State() {
		return goods_State;
	}
	public void setGoods_State(String goods_State) {
		this.goods_State = goods_State;
	}
	public String getPhone_Num() {
		return phone_Num;
	}
	public void setPhone_Num(String phone_Num) {
		this.phone_Num = phone_Num;
	}
	public int getGoods_Code() {
		return goods_Code;
	}
	public void setGoods_Code(int goods_Code) {
		this.goods_Code = goods_Code;
	}
	public String getSeller_Id() {
		return seller_Id;
	}
	public void setSeller_Id(String seller_Id) {
		this.seller_Id = seller_Id;
	}
	public String getGoods_Name() {
		return goods_Name;
	}
	public void setGoods_Name(String goods_Name) {
		this.goods_Name = goods_Name;
	}
	public String getGoods_Cate() {
		return goods_Cate;
	}
	public void setGoods_Cate(String goods_Cate) {
		this.goods_Cate = goods_Cate;
	}
	public int getGoods_Price() {
		return goods_Price;
	}
	public void setGoods_Price(int goods_Price) {
		this.goods_Price = goods_Price;
	}
	public int getGoods_Sta() {
		return goods_Sta;
	}
	public void setGoods_Sta(int goods_Sta) {
		this.goods_Sta = goods_Sta;
	}
	public String getGoods_Des() {
		return goods_Des;
	}
	public void setGoods_Des(String goods_Des) {
		this.goods_Des = goods_Des;
	}
	public String getGoods_Pic() {
		return goods_Pic;
	}
	public void setGoods_Pic(String goods_Pic) {
		this.goods_Pic = goods_Pic;
	}
	public Date getGoods_Date() {
		return goods_Date;
	}
	public void setGoods_Date(Date goods_Date) {
		this.goods_Date = goods_Date;
	}
	
	
}