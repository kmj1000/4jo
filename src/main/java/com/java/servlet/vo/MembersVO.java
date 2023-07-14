package com.java.servlet.vo;

public class MembersVO {

	private String nickname;
	private String email;
	private String pwd;
	private String name;
	private int phone;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MembersVO ["
				+ "nickname=" + nickname 
				+ ", email=" + email 
				+ ", pwd=" + pwd 
				+ ", name=" + name 
				+ ", phone=" + phone + "]";
	}

	

	
}
