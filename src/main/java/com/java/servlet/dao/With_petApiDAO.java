package com.java.servlet.dao;

import com.java.servlet.vo.Favorite_W_VO;
import com.java.servlet.vo.With_petVO;


public interface With_petApiDAO {
	int insertWith_petData(With_petVO vo);
	int deleteWith_petData(int with_pet_no);
}