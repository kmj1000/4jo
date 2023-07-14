package com.spring.mapper;

import java.util.List;

import com.spring.domain.MemberDTO;

public interface MemberApiMapper {
	List<MemberDTO> selectMemberList();
	int selectMemberCnt(MemberDTO member);

	int deleteMember(MemberDTO member);
	
	int updateMemberName(MemberDTO member);
	
	int insertMember(MemberDTO member);

	
}
