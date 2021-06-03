package com.capstone.domain;

public class TradeVO {
	private String trade_Code;
	private int goods_Code;
	private String seller_Id;
	private String buyer_Id;
	private int trade_State;
	private int trade_Re_Star;
	private String trade_Re_Line;
	
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
	public int getTrade_Re_Star() {
		return trade_Re_Star;
	}
	public void setTrade_Re_Star(int trade_Re_Star) {
		this.trade_Re_Star = trade_Re_Star;
	}
	public String getTrade_Re_Line() {
		return trade_Re_Line;
	}
	public void setTrade_Re_Line(String trade_Re_Line) {
		this.trade_Re_Line = trade_Re_Line;
	}
	
}
