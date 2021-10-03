package com.capstone.domain;

import java.util.Date;

public class TradeVO {
	private String trade_Code;
	private int goods_Code;
	private String seller_Id;
	private String buyer_Id;
	private int trade_State;
	private Date trade_Date;
	private String buyer_Phone;
	private String goods_Title;

	
	
	
	public Date getTrade_Date() {
		return trade_Date;
	}
	public void setTrade_Date(Date trade_Date) {
		this.trade_Date = trade_Date;
	}
	public String getBuyer_Phone() {
		return buyer_Phone;
	}
	public void setBuyer_Phone(String buyer_Phone) {
		this.buyer_Phone = buyer_Phone;
	}
	public String getGoods_Title() {
		return goods_Title;
	}
	public void setGoods_Title(String goods_Title) {
		this.goods_Title = goods_Title;
	}
	public String getTrade_Code() {
		return trade_Code;
	}
	public void setTrade_Code(String trade_Code) {
		this.trade_Code = trade_Code;
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
	public String getBuyer_Id() {
		return buyer_Id;
	}
	public void setBuyer_Id(String buyer_Id) {
		this.buyer_Id = buyer_Id;
	}
	public int getTrade_State() {
		return trade_State;
	}
	public void setTrade_State(int trade_State) {
		this.trade_State = trade_State;
	}

	
}