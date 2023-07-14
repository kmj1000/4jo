package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.CommuResultDTO;
import com.spring.domain.CommunityDTO;
import com.spring.mapper.CommunityApiMapper;
import com.spring.service.CommunityApiService;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/api/*")
@RequiredArgsConstructor
public class CommunityController {
	private final CommunityApiMapper mapper;
	private final CommunityApiService service;
	
	//http://192.168.0.69:8080/ex00/api/communitylist?serviceKey=1234
	@GetMapping(value="/communitylist")
	public List<CommunityDTO> selectCommunityList(@RequestParam("serviceKey") String serviceKey){
		List<CommunityDTO> list=mapper.selectCommunityList();
		serviceKey="1234";
		log.info(list);
		
		return list; 
	}
	
	//http://localhost:8080/ex00/api/communityregi?nickname=뚜연&title=안녕난예찌도움이필요하지&content=될랑가모르겟넿ㅎㅎ
	@GetMapping(value="/communityregi")
	public CommuResultDTO communityregi(CommunityDTO community) {
		log.info("communityregi");
		log.info(community);
			   
		return service.registerCommunity(community);
	}
		   
	//http://localhost:8080/ex00/api/communityupdate?title=&content=내용수정!&c_no=41
	@GetMapping(value="/communityupdate")
	public CommuResultDTO communityupdate(CommunityDTO community) {
		log.info("communityupdate");
		log.info(community);
		   
		return service.modifyCommunity(community);
	}
	
	//http://localhost:8080/ex00/api/communityremove?c_no=41
	@GetMapping(value="/communityremove")
	public CommuResultDTO communityremove(CommunityDTO community) {
		log.info("communityremove");
		log.info(community);
			   
		return service.removeCommunity(community);
	}
	
	 //http://localhost:8080/ex00/api/ex11?id=jemminy01&pwd=d5e39bdaf0cb61674bc102474dbfa50dc0a4aaa48d1aa0a7e45e713f24ece0348b2e439ff9e2840c804bf6268a408fc73232bd87635ab040a3cab9fac6bf7e5c
	   @GetMapping(value="/check")
	   public CommuResultDTO check(CommunityDTO community){
		   log.info("check");
		   log.info(community);
		   // db 갔다오기
		  
		   return service.CommunityCheck(community);   
	   }

	
}
