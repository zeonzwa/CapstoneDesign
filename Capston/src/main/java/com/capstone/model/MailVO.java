package com.capstone.model;

public class MailVO {
	
	private String Id; //아이디
	private String Pw; //비밀번호
	private String Name; //이름
	private String Major; //전공
	private String Student_Num; //학번
	private String Email; //이메일
	private String Phone_Num; //전화번호
	
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
	public String getStudent_Num() {
		return Student_Num;
	}
	public void setStudent_Num(String student_Num) {
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
	@Override
	public String toString() {
		return "MailVO [Id=" + Id + ", Pw=" + Pw + ", Name=" + Name + ", Major=" + Major + ", Student_Num="
				+ Student_Num + ", Email=" + Email + ", Phone_Num=" + Phone_Num + "]";
	}
	
	
	
}