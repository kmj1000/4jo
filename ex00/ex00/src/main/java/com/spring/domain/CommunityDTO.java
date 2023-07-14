package com.spring.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommunityDTO {
	private int c_no;	//C_NO     NOT NULL NUMBER         
	private String nickname;	//NICKNAME NOT NULL VARCHAR2(30)   
	private String title;	//TITLE    NOT NULL VARCHAR2(200)  
	private String content;    //CONTENT  NOT NULL VARCHAR2(3000) 
	private String reg_date;    //REG_DATE    DATE  
}
