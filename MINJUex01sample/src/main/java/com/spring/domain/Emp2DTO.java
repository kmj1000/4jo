package com.spring.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Emp2DTO {
	 private int empno;       //number , 
	 private String name;        //varchar2(100), 
	 private Date birthday;    //date,
	 private String deptno;      //varchar2(100), 
	 private String emp_type;    //varchar2(100),
	 private String tel;         //varchar2(100),
	 private String hobby;       //varchar2(100),
	 private int pay;         //number,
	 private String position;    //varchar2(100),
	 private int pempno;      //number
}
