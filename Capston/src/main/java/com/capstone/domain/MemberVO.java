package com.capstone.domain;

public class MemberVO {
	
	private String Id;
	private String Pw;
	private String Name;
	private String Major;
	private int Student_Num;
	private String Email;
	private String Phone_Num;
	private int tal_Sta;
	private int goods_Sta;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public int getStudent_Num() {
		return Student_Num;
	}
	public void setStudent_Num(int student_Num) {
		Student_Num = student_Num;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone_Num() {
		return Phone_Num;
	}
	public void setPhone_Num(String phone_Num) {
		Phone_Num = phone_Num;
	}
	public int getTal_Sta() {
		return tal_Sta;
	}
	public void setTal_Sta(int tal_Sta) {
		this.tal_Sta = tal_Sta;
	}
	public int getGoods_Sta() {
		return goods_Sta;
	}
	public void setGoods_Sta(int goods_Sta) {
		this.goods_Sta = goods_Sta;
	}
	
	
}