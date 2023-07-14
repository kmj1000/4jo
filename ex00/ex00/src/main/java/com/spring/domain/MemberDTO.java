package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {
	private int m_no;	//M_NO  NOT NULL NUMBER 
	private String name;	//NAME  NOT NULL VARCHAR2(21) 
	private String jumin;	//JUMIN NOT NULL VARCHAR2(13)
	private String id;    //ID    NOT NULL VARCHAR2(20) 
	private String pwd;    //PWD   NOT NULL VARCHAR2(128)
	

}
