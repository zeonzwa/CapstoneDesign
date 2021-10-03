package com.capstone.domain;

import java.util.Date;

public class Trade_T_VO {
	private String trade_T_Code;
	private String talent_Code;
	private String seller_Id;
	private String buyer_Id;
	private int trade_T_State;
	private String talent_Title;
	private Date trade_T_Date;
	private String buyer_Phone;
	private String talent_Kinds;
	private String talent_Kinds_2;
	
	
	
	public String getTalent_Kinds() {
		return talent_Kinds;
	}
	public void setTalent_Kinds(String talent_Kinds) {
		this.talent_Kinds = talent_Kinds;
	}
	public String getTalent_Kinds_2() {
		return talent_Kinds_2;
	}
	public void setTalent_Kinds_2(String talent_Kinds_2) {
		this.talent_Kinds_2 = talent_Kinds_2;
	}
	public String getTalent_Title() {
		return talent_Title;
	}
	public void setTalent_Title(String talent_Title) {
		this.talent_Title = talent_Title;
	}
	public Date getTrade_T_Date() {
		return trade_T_Date;
	}
	public void setTrade_T_Date(Date trade_T_Date) {
		this.trade_T_Date = trade_T_Date;
	}
	public String getBuyer_Phone() {
		return buyer_Phone;
	}
	public void setBuyer_Phone(String buyer_Phone) {
		this.buyer_Phone = buyer_Phone;
	}
	public String getTrade_T_Code() {
		return trade_T_Code;
	}
	public void setTrade_T_Code(String trade_T_Code) {
		this.trade_T_Code = trade_T_Code;
	}
	public String getTalent_Code() {
		return talent_Code;
	}
	public void setTalent_Code(String talent_Code) {
		this.talent_Code = talent_Code;
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
	public int getTrade_T_State() {
		return trade_T_State;
	}
	public void setTrade_T_State(int trade_T_State) {
		this.trade_T_State = trade_T_State;
	}
	
	
	
	
}