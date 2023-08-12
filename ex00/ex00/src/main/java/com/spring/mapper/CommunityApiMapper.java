package com.spring.mapper;

import java.util.List;

import com.spring.domain.CommunityDTO;

public interface CommunityApiMapper {
	List<CommunityDTO> selectCommunityList();

	int insertCommunity(CommunityDTO community);
	int updateCommunity(CommunityDTO community);
	int deleteCommunity(CommunityDTO community);

	int CommunityCnt(CommunityDTO community);
}
