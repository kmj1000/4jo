package com.java.servlet.vo;

public class Favorite_S_VO {
	private int favorite_shelter_no;
    private String nickname;
    private String careNm;
    private String careAddr;
    private String careTel;
    
	
	
	public int getFavorite_shelter_no() {
		return favorite_shelter_no;
	}



	public void setFavorite_shelter_no(int favorite_shelter_no) {
		this.favorite_shelter_no = favorite_shelter_no;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
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



	@Override
	public String toString() {

		return "Favorite_S_VO["
				+"favorite_shelter_no = "+favorite_shelter_no+", "
				+"nickname = "+nickname+", "
				+"careNm = "+careNm+", "
				+"careAddr = "+careAddr+", "
				+"careTel = "+careTel+"]"
				;
	}
	

}
