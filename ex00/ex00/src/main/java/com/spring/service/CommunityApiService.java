package com.spring.service;

import com.spring.domain.CommuResultDTO;
import com.spring.domain.CommunityDTO;

public interface CommunityApiService {
	CommuResultDTO registerCommunity(CommunityDTO community);
	CommuResultDTO modifyCommunity(CommunityDTO community);
	CommuResultDTO removeCommunity(CommunityDTO community);
	CommuResultDTO CommunityCheck(CommunityDTO community);
}
