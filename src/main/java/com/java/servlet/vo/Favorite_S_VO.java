package com.java.servlet.vo;

import java.sql.Date;

public class Favorite_S_VO {
	private int favorites_no;
    private String nickname;
    private Date favorites_reg_date;
    private int shelter_no;
    private String careNm; 
	private String divisionNm; 
	private String saveTrgtAnimal; 
	private String careAddr; 
	private String weekOprStime; 
	private String weekOprEtime;
	private String weekCellStime; 
	private String weekCellEtime; 
	private String weekendOprStime; 
	private String weekendOprEtime; 
	private String weekendCellStime; 
	private String weekendCellEtime; 
	private String closeDay;
	private String careTel;
  

	@Override
	public String toString() {
		
		return "Favorite_S_VO["
				+"favorites_no = "+favorites_no+", "
				+"nickname = "+nickname+", "
				+"favorites_reg_date = "+favorites_reg_date+"\n"
				+"shelter_no = "+shelter_no+"\n"
				+"careNm = "+careNm+"\n"
				+"careAddr = "+careAddr+"\n"
				+"careTel = "+careTel+"\n"
				
				
				;
	}


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


	public String getCareNm() {
		return careNm;
	}


	public void setCareNm(String careNm) {
		this.careNm = careNm;
	}


	public String getDivisionNm() {
		return divisionNm;
	}


	public void setDivisionNm(String divisionNm) {
		this.divisionNm = divisionNm;
	}


	public String getSaveTrgtAnimal() {
		return saveTrgtAnimal;
	}


	public void setSaveTrgtAnimal(String saveTrgtAnimal) {
		this.saveTrgtAnimal = saveTrgtAnimal;
	}


	public String getCareAddr() {
		return careAddr;
	}


	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}


	public String getWeekOprStime() {
		return weekOprStime;
	}


	public void setWeekOprStime(String weekOprStime) {
		this.weekOprStime = weekOprStime;
	}


	public String getWeekOprEtime() {
		return weekOprEtime;
	}


	public void setWeekOprEtime(String weekOprEtime) {
		this.weekOprEtime = weekOprEtime;
	}


	public String getWeekCellStime() {
		return weekCellStime;
	}


	public void setWeekCellStime(String weekCellStime) {
		this.weekCellStime = weekCellStime;
	}


	public String getWeekCellEtime() {
		return weekCellEtime;
	}


	public void setWeekCellEtime(String weekCellEtime) {
		this.weekCellEtime = weekCellEtime;
	}


	public String getWeekendOprStime() {
		return weekendOprStime;
	}


	public void setWeekendOprStime(String weekendOprStime) {
		this.weekendOprStime = weekendOprStime;
	}


	public String getWeekendOprEtime() {
		return weekendOprEtime;
	}


	public void setWeekendOprEtime(String weekendOprEtime) {
		this.weekendOprEtime = weekendOprEtime;
	}


	public String getWeekendCellStime() {
		return weekendCellStime;
	}


	public void setWeekendCellStime(String weekendCellStime) {
		this.weekendCellStime = weekendCellStime;
	}


	public String getWeekendCellEtime() {
		return weekendCellEtime;
	}


	public void setWeekendCellEtime(String weekendCellEtime) {
		this.weekendCellEtime = weekendCellEtime;
	}


	public String getCloseDay() {
		return closeDay;
	}


	public void setCloseDay(String closeDay) {
		this.closeDay = closeDay;
	}


	public String getCareTel() {
		return careTel;
	}


	public void setCareTel(String careTel) {
		this.careTel = careTel;
	}



















}
