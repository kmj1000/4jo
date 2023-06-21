package com.java.servlet.vo;

import java.util.Date;

public class CommunityVO {
	private int c_no;
    private String nickname;
    private String title;
    private String content;
    private Date reg_date;
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "CommunityVO [c_no=" + c_no + ", nickname=" + nickname + ", title=" + title + ", content=" + content
				+ ", reg_date=" + reg_date + "]";
	}
    
    
}
