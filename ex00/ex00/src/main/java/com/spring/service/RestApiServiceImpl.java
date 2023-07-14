package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.domain.MemberDTO;
import com.spring.domain.ResultDTO;
import com.spring.mapper.MemberApiMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestApiServiceImpl implements RestApiService{
	@NonNull
	private MemberApiMapper mapper;
	
	@Override
	public ResultDTO getMemberCheck(MemberDTO member) {
		ResultDTO result=new ResultDTO();
		int cnt=mapper.selectMemberCnt(member);
		String msg="";
		if(cnt==1) {
			result.setUser_cnt(cnt);
			msg="하이 유저";
		}else {
			msg="바이 낫유저";
		}
		result.setMsg(msg);
		return result;
		
	}

	@Override
	public ResultDTO removeMember(MemberDTO member) {
		ResultDTO result=new ResultDTO();
		int cnt=mapper.deleteMember(member);
		
		result.setUser_cnt(cnt);
		String msg="";
		
		if(cnt==1) {
			msg="m_no : "+member.getM_no()+"번 유저 삭제";
		}else {
			msg="m_no : "+member.getM_no()+"번 유저 삭제 실패";
		}
		result.setMsg(msg);
		return result;
	}

	@Override
	public ResultDTO modifyMemberName(MemberDTO member) {
		ResultDTO result=new ResultDTO();
		int cnt=mapper.updateMemberName(member);
		
		result.setUser_cnt(cnt);
		String msg="";
		
		if(cnt==1) {
			msg="m_no : "+member.getM_no()+"번 유저 수정";
		}else {
			msg="m_no : "+member.getM_no()+"번 유저 수정 실패";
		}
		result.setMsg(msg);
		return result;
	}

	@Override
	public ResultDTO registerMember(MemberDTO member) {
		ResultDTO result=new ResultDTO();
		int cnt=mapper.insertMember(member);
		
		result.setUser_cnt(cnt);
		String msg="";
		
		if(cnt==1) {
			msg="m_no : "+member.getM_no()+"번 유저 등록";
		}else {
			msg="m_no : "+member.getM_no()+"번 유저 등록 실패";
		}
		result.setMsg(msg);
		return result;
	}
	
}
