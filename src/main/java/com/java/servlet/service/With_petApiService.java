package com.java.servlet.service;


import com.java.servlet.vo.Favorite_W_VO;
import com.java.servlet.vo.With_petVO;

public interface With_petApiService {
	int registerWith_pet(With_petVO vo);
	int removeWith_pet(int with_pet_no);
}
