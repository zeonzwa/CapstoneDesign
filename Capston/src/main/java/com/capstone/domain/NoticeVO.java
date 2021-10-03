package com.capstone.domain;

import java.util.Date;

public class NoticeVO {
	private String notice_Title;
	private String notice_Content;
	private Date notice_Date;
	private int notice_Num;
	
	
	public int getNotice_Num() {
		return notice_Num;
	}
	public void setNotice_Num(int notice_Num) {
		this.notice_Num = notice_Num;
	}
	public String getNotice_Title() {
		return notice_Title;
	}
	public void setNotice_Title(String notice_Title) {
		this.notice_Title = notice_Title;
	}
	public String getNotice_Content() {
		return notice_Content;
	}
	public void setNotice_Content(String notice_Content) {
		this.notice_Content = notice_Content;
	}
	public Date getNotice_Date() {
		return notice_Date;
	}
	public void setNotice_Date(Date notice_Date) {
		this.notice_Date = notice_Date;
	}
	
	
}