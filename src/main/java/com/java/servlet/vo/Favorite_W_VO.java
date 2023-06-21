package com.java.servlet.vo;

import java.util.Date;

public class Favorite_W_VO {
	private int favorite_with_pet_no;
	private int with_pet_no;
    private String nickname;
    private String w_name;
    private String tel;
    private String road;
    
	public int getFavorite_with_pet_no() {
		return favorite_with_pet_no;
	}
	public void setFavorite_with_pet_no(int favorite_with_pet_no) {
		this.favorite_with_pet_no = favorite_with_pet_no;
	}
	public int getWith_pet_no() {
		return with_pet_no;
	}
	public void setWith_pet_no(int with_pet_no) {
		this.with_pet_no = with_pet_no;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	
	@Override
	public String toString() {
		return "Favorite_W_VO [favorite_with_pet_no=" + favorite_with_pet_no + ", with_pet_no=" + with_pet_no
				+ ", nickname=" + nickname + ", w_name=" + w_name + ", tel=" + tel + ", road=" + road + "]";
	}
    
    
}
