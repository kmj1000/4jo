package com.spring.domain;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class sDTO {
	private int studno;
	private String name;
	private String id;
	private int grade;
	private String jumin;
	private Date birthday;                
	private String tel;               
	private int height;            
	private int weight;                
	private int deptno1;          
	private int deptno2;              
	private int profno;                
}
