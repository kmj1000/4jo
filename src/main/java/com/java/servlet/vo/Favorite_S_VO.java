package com.java.servlet.vo;

public class Favorite_S_VO {
	private int favorite_shelter_no;
	private int shelter_no;
	private String nickname;
	private String careNmShelter;
	private String careAddrShelter;
	private String careTelShelter;
	public int getFavorite_shelter_no() {
		return favorite_shelter_no;
	}
	public void setFavorite_shelter_no(int favorite_shelter_no) {
		this.favorite_shelter_no = favorite_shelter_no;
	}
	public int getShelter_no() {
		return shelter_no;
	}
	public void setShelter_no(int shelter_no) {
		this.shelter_no = shelter_no;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCareNmShelter() {
		return careNmShelter;
	}
	public void setCareNmShelter(String careNmShelter) {
		this.careNmShelter = careNmShelter;
	}
	public String getCareAddrShelter() {
		return careAddrShelter;
	}
	public void setCareAddrShelter(String careAddrShelter) {
		this.careAddrShelter = careAddrShelter;
	}
	public String getCareTelShelter() {
		return careTelShelter;
	}
	public void setCareTelShelter(String careTelShelter) {
		this.careTelShelter = careTelShelter;
	}
	
	@Override
	public String toString() {
		return "Favorite_S_VO["
				+"favorite_shelter_no"+favorite_shelter_no
				+"shelter_no"+shelter_no
				+"nickname"+nickname
				+"careNmShelter"+careNmShelter
				+"careAddrShelter"+careAddrShelter
				+"careTelShelter"+careTelShelter+"]"
				;
	}
	
}
