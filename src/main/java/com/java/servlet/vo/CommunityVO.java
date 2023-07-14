package com.java.servlet.vo;
	
import java.util.Date;
// 가보자고~~~
public class CommunityVO {
	private int c_no;
    private String title;
    private String content;
    private Date reg_date;
    private String nickname;
	
    public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "CommunityVO[c_no=" + c_no 
				+ ", title=" + title 
				+ ", content=" + content
				+ ", reg_date=" + reg_date 
				+ ", nickname=" + nickname 
				+ "]";
	}
    
    
}
