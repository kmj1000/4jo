package com.java.servlet.vo;

import java.sql.Date;

public class Favorite_W_VO {
	private int favoritew_no;
    private String nickname;
    private Date favoritew_reg_date;
    private int with_pet_no;
    private String building;
    private String road;
    private String tel;



	public int getFavoritew_no() {
		return favoritew_no;
	}



	public void setFavoritew_no(int favoritew_no) {
		this.favoritew_no = favoritew_no;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public Date getFavoritew_reg_date() {
		return favoritew_reg_date;
	}



	public void setFavoritew_reg_date(Date favoritew_reg_date) {
		this.favoritew_reg_date = favoritew_reg_date;
	}



	public int getWith_pet_no() {
		return with_pet_no;
	}



	public void setWith_pet_no(int with_pet_no) {
		this.with_pet_no = with_pet_no;
	}



	public String getBuilding() {
		return building;
	}



	public void setBuilding(String building) {
		this.building = building;
	}



	public String getRoad() {
		return road;
	}



	public void setRoad(String road) {
		this.road = road;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	@Override
	public String toString() {
		
	    String withpetInfo = "문화시설 정보: [문화시설이름 = " + building + ",전화번호 = " + tel+", 주소 = " + road  + "]";

		return "Favorite_W_VO["
				+"favoritew_no = "+favoritew_no+", "
				+"nickname = "+nickname+", "
				+"favoritew_reg_date = "+favoritew_reg_date+"\n"
				+"with_pet_no = "+with_pet_no+"\n"
				+withpetInfo +"]"
				;
	}

}
