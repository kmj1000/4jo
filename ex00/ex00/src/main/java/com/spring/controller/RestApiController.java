package com.spring.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.spring.domain.MemberDTO;
import com.spring.domain.ResultDTO;
import com.spring.domain.SampleDTO;
import com.spring.domain.SampleDTOList;
import com.spring.service.RestApiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/api/*")
@RequiredArgsConstructor
public class RestApiController {
	private final RestApiService service;
	// 경미씨 컴퓨터 켜야함 
	// 그래요
	
	// http://localhost:8080/ex00/api/ex01
	@GetMapping("/ex01")
	public SampleDTO ex01() {
		SampleDTO dto = new SampleDTO(); //com.spring.domain
		dto.setName("ex01");
		dto.setAge(30);
		
		return dto;
	}
	
	// http://localhost:8080/ex00/api/ex02
	@GetMapping("/ex02")
	public String ex02() {
		//"\\{name:;'sam' , age:30 \\}"
		Gson gson = new Gson();
		JsonObject dto = new JsonObject();
		dto.addProperty("name", "ex02");
		dto.addProperty("age", 34);
		
		return gson.toJson(dto);
	}
	
	@RequestMapping(value = "ex03" , method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public ResponseEntity<String> ex03(){
		Gson gson = new Gson();
		JsonObject dto = new JsonObject();
		dto.addProperty("name", "ex03");
		dto.addProperty("age", 34);
		
		return new ResponseEntity<String>(gson.toJson(dto), HttpStatus.FOUND);
	}
	
	public  ResponseEntity<SampleDTO> ex04(){
	SampleDTO dto = new SampleDTO(); //com.spring.domain
	dto.setName("ex04");
	dto.setAge(30);
	
	HttpHeaders header = new HttpHeaders();
	header.add("Content-type", "application/json;charset=UTF-8");
	
	return new ResponseEntity<SampleDTO>(dto, header, HttpStatus.OK);
}
	//http://localhost:8080/ex00/api/ex05.json
	   @GetMapping(value = "ex05" , produces= {MediaType.APPLICATION_XML_VALUE,
	         MediaType.APPLICATION_JSON_VALUE})
	   public SampleDTO ex05() {
	      return new SampleDTO("스프링", 31);
	   }
	   
	   
	   ///////////////////////////////////////////
	   //////////////// parameter ////////////////
	   ///////////////////////////////////////////
	   //http://localhost:8080/ex00/api/ex06?name=홍동&age=80

	   @GetMapping("/ex06")
	   public SampleDTO ex06(SampleDTO dto) {
		   return dto;
	   }
	   
	   //http://localhost:8080/ex00/api/ex07?name=홍동&age=80&name=김동&age=60&name=박동&age=40

	   @GetMapping(value="/ex07", produces= {MediaType.APPLICATION_JSON_VALUE})
	   public String[] ex07(String[] name) {
		   log.info("ex07");
		   log.info("name[0] - "+name[0]);
		   log.info("name[1] - "+name[1]);
		   return name;
	   }
	   
	   //http://localhost:8080/ex00/api/ex08?name=홍동&name=김동&name=박동
	   @GetMapping(value="/ex08", produces= {MediaType.APPLICATION_JSON_VALUE})
	   public ArrayList<String> ex08(@RequestParam("name") ArrayList<String> list) {
		   log.info("ex08");
		   log.info("list[0] - "+list.get(0));
		   log.info("list[1] - "+list.get(1));
		   return list;
	   }
	   
	   //http://localhost:8080/ex00/api/ex09/sam
	   @GetMapping(value="/ex09/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	   public String ex09(@PathVariable("id") String id){
		   log.info("ex09");
		   log.info("id - "+id);
		
		   JsonObject obj=new JsonObject();
		   obj.addProperty("id",id);
		   
		   return new Gson().toJson(obj);
		   
	   }
	   
	   //http://localhost:8080/ex00/api/ex10?list%5B0%5D.name=홍동&list%5B0%5D.age=30&list%5B1%5D.name=김동&list%5B1%5D.age=40
	   // [ = %5B 
	   // ] = %5D
	   @GetMapping(value="/ex10", produces= {MediaType.APPLICATION_JSON_VALUE})
	   public List<SampleDTO> ex10(SampleDTOList list){ // <-javascript에서 List 받고싶을때 ()괄호안의 형식으로 써야함 
		   												// ArrayList<어쩌구DTO> list <- 이런거안됨
		   log.info("ex10");
		   
		   return list.getList();
		   
	   }
	   //http://localhost:8080/ex00/api/ex11?id=jemminy01&pwd=d5e39bdaf0cb61674bc102474dbfa50dc0a4aaa48d1aa0a7e45e713f24ece0348b2e439ff9e2840c804bf6268a408fc73232bd87635ab040a3cab9fac6bf7e5c
	   @GetMapping(value="/ex11", produces= {MediaType.APPLICATION_JSON_VALUE})
	   public ResultDTO ex11(MemberDTO member){
		   log.info("ex11");
		   log.info(member);
		   // db 갔다오기
		  
		   return service.getMemberCheck(member);   
	   }
	   
	   //http://localhost:8080/ex00/api/ex12?m_no=1063
	   @GetMapping(value="/ex12", produces= {MediaType.APPLICATION_JSON_VALUE})
	   public ResultDTO ex12(MemberDTO member) {
		   log.info("ex12");
		   log.info(member);
		   
		   return service.removeMember(member);
	   }
	   
	   //http://localhost:8080/ex00/api/ex13?name='잼민업뎃'&m_no=1043
	   @GetMapping(value="/ex13", produces= {MediaType.APPLICATION_JSON_VALUE})
	   public ResultDTO ex13(MemberDTO member) {
		   log.info("ex12");
		   log.info(member);
		   
		   return service.modifyMemberName(member);
	   }
	   
	 //http://localhost:8080/ex00/api/ex14?name=줴미니&jumin=2307061111111&id=jemminy01&pwd=1111
	   @GetMapping(value="/ex14", produces= {MediaType.APPLICATION_JSON_VALUE})
	   public ResultDTO ex14(MemberDTO member) {
		   log.info("ex12");
		   log.info(member);
		   
		   return service.registerMember(member);
	   }
	   
	}
