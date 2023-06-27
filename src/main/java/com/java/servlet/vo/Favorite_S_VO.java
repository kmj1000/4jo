package com.java.servlet.vo;

import java.sql.Date;

public class Favorite_S_VO {
	private int favorites_no;
    private String nickname;
    private Date favorites_reg_date;
    private int shelter_no;
    private String careNm;
    private String careAddr;
    private String careTel;
  

	

	public int getFavorites_no() {
		return favorites_no;
	}









	public void setFavorites_no(int favorites_no) {
		this.favorites_no = favorites_no;
	}









	public String getNickname() {
		return nickname;
	}









	public void setNickname(String nickname) {
		this.nickname = nickname;
	}









	public Date getFavorites_reg_date() {
		return favorites_reg_date;
	}









	public void setFavorites_reg_date(Date favorites_reg_date) {
		this.favorites_reg_date = favorites_reg_date;
	}









	public int getShelter_no() {
		return shelter_no;
	}









	public void setShelter_no(int shelter_no) {
		this.shelter_no = shelter_no;
	}









	@Override
	public String toString() {
		String shelterInfo = "보호소 정보: [보호소이름 = " + careNm + ", 전화번호 = " + careTel + ", 주소 = " + careAddr + "]";
	    

		return "FavoriteVO["
				+"favorites_no = "+favorites_no+", "
				+"nickname = "+nickname+", "
				+"favorites_reg_date = "+favorites_reg_date+"\n"
				+"shelter_no = "+shelter_no
				+shelterInfo + "\n" 
				
				;
	}









	public String getCareNm() {
		return careNm;
	}









	public void setCareNm(String careNm) {
		this.careNm = careNm;
	}









	public String getCareAddr() {
		return careAddr;
	}









	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}









	public String getCareTel() {
		return careTel;
	}









	public void setCareTel(String careTel) {
		this.careTel = careTel;
	}












}
