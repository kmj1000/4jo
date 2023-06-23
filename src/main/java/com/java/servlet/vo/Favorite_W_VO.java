package com.java.servlet.vo;

<<<<<<< HEAD
public class Favorite_W_VO {
	private int favorite_with_pet_no;
=======

import java.util.Date;


public class Favorite_W_VO {
	private int favorite_with_pet_no;
	private int with_pet_no;
>>>>>>> ed81ee7ca8f32029becf6c345ad661fa3f8c0644
    private String nickname;
    private String 시설명;
    private String 전화번호;
    private String 도로명주소;
    
	public int getFavorite_with_pet_no() {
		return favorite_with_pet_no;
	}

	public void setFavorite_with_pet_no(int favorite_with_pet_no) {
		this.favorite_with_pet_no = favorite_with_pet_no;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String get시설명() {
		return 시설명;
	}

	public void set시설명(String 시설명) {
		this.시설명 = 시설명;
	}

	public String get전화번호() {
		return 전화번호;
	}

	public void set전화번호(String 전화번호) {
		this.전화번호 = 전화번호;
	}
	public String get도로명주소() {
		return 도로명주소;
	}
	public void set도로명주소(String 도로명주소) {
		this.도로명주소 = 도로명주소;
	}
	@Override
	public String toString() {

		return "Favorite_W_VO["
				+"favorite_with_pet_no = "+favorite_with_pet_no+", "
				+"nickname = "+nickname+", "
				+"시설명 = "+시설명+", "
				+"전화번호 = "+전화번호+", "
				+"도로명주소 = "+도로명주소+"]"
				;
	}
<<<<<<< HEAD
=======

>>>>>>> ed81ee7ca8f32029becf6c345ad661fa3f8c0644
}
