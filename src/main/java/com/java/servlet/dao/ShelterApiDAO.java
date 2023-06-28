package com.java.servlet.dao;

import com.java.servlet.vo.ShelterVO;


public interface ShelterApiDAO {
	int insertShelterData(ShelterVO vo);
	int deleteShelterData(int favorites_no);
}
