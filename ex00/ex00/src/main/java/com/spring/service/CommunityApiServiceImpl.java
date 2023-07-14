package com.spring.service;

import com.spring.domain.CommunityDTO;

import org.springframework.stereotype.Service;

import com.spring.domain.CommuResultDTO;
import com.spring.mapper.CommunityApiMapper;
import com.spring.mapper.MemberApiMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityApiServiceImpl implements CommunityApiService {
	private final CommunityApiMapper mapper;
	
	@Override
	public CommuResultDTO CommunityCheck (CommunityDTO community) {
		CommuResultDTO result=new CommuResultDTO();
		int cnt=mapper.CommunityCnt(community);
		String msg="";
		if(cnt==1) {
			result.setCommu_cnt(cnt);
			msg="O";
		}else {
			msg="X";
		}
		result.setMsg(msg);
		return result;
		
	}

	@Override
	public CommuResultDTO registerCommunity(CommunityDTO community) {
		CommuResultDTO result=new CommuResultDTO();
		int cnt=mapper.insertCommunity(community);
		
		result.setCommu_cnt(cnt);
		String msg="";
		
		if(cnt==1) {
			msg="c_no : "+community.getC_no()+"번 글 등록";
		}else {
			msg="c_no : "+community.getC_no()+"번 글 등록 실패";
		}
		result.setMsg(msg);
		return result;
	}
	
	@Override
	public CommuResultDTO modifyCommunity(CommunityDTO community) {
		CommuResultDTO result=new CommuResultDTO();
		int cnt=mapper.updateCommunity(community);
		
		result.setCommu_cnt(cnt);
		String msg="";
		
		if(cnt==1) {
			msg="c_no : "+community.getC_no()+"번 글 수정";
		}else {
			msg="c_no : "+community.getC_no()+"번 글 수정 실패";
		}
		result.setMsg(msg);
		return result;
	}
	
	@Override
	public CommuResultDTO removeCommunity(CommunityDTO community) {
		CommuResultDTO result=new CommuResultDTO();
		int cnt=mapper.deleteCommunity(community);
		
		result.setCommu_cnt(cnt);
		String msg="";
		
		if(cnt==1) {
			msg="c_no : "+community.getC_no()+"번 글 삭제";
		}else {
			msg="c_no : "+community.getC_no()+"번 글 삭제 실패";
		}
		result.setMsg(msg);
		return result;
	}
	
	
}
