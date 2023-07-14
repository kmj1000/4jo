package com.java.servlet.service;

import com.java.servlet.vo.Favorite_S_VO;
import com.java.servlet.vo.ShelterVO;

public interface ShelterApiService {
	int registerShelter(ShelterVO vo);
	int removeShelter(int shelter_no);
}
