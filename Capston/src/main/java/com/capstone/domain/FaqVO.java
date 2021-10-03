package com.capstone.domain;

import java.util.Date;

public class FaqVO {
	private String faq_Title;
	private String faq_Kinds;
	private String faq_Content;
	private Date faq_Date;
	private String faq_Id;
	public String getFaq_Title() {
		return faq_Title;
	}
	public void setFaq_Title(String faq_Title) {
		this.faq_Title = faq_Title;
	}
	public String getFaq_Kinds() {
		return faq_Kinds;
	}
	public void setFaq_Kinds(String faq_Kinds) {
		this.faq_Kinds = faq_Kinds;
	}
	public String getFaq_Content() {
		return faq_Content;
	}
	public void setFaq_Content(String faq_Content) {
		this.faq_Content = faq_Content;
	}
	public Date getFaq_Date() {
		return faq_Date;
	}
	public void setFaq_Date(Date faq_Date) {
		this.faq_Date = faq_Date;
	}
	public String getFaq_Id() {
		return faq_Id;
	}
	public void setFaq_Id(String faq_Id) {
		this.faq_Id = faq_Id;
	}
}
