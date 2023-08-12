package com.spring.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpDTO {
	private int empno;//     number, 
	private String ename;//     varchar2(100), 
	private String job;//      varchar2(100), 
	private int mgr ;//      number, 
	private Date hiredate;//  date, 
	private int sal;//      number,
	private int comm;//     number, 
	private int deptno;//   
}
