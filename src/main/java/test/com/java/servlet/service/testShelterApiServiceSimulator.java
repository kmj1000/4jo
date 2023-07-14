package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.java.servlet.service.ShelterApiService;
import com.java.servlet.service.impl.ShelterApiServiceImpl;
import com.java.servlet.vo.Favorite_S_VO;
import com.java.servlet.vo.ShelterVO;


class testShelterApiServiceSimulator {
	private final ShelterApiService service = ShelterApiServiceImpl.getInstance();
Date favorites_reg_date = new Date(System.currentTimeMillis());
	@Test
	void testRegisterShelter() {
		ShelterVO vo = new ShelterVO();
		Favorite_S_VO vo2 = new Favorite_S_VO();
		vo2.setFavorites_no(1);
		vo2.setNickname("bb");
		vo2.setFavorites_reg_date(favorites_reg_date);
		vo.setShelter_no(2);
		vo.setCareNm("bb");
		vo.setCareAddr("bb");
		vo.setCareTel("bb");
		assertEquals(1,service.registerShelter(vo));	
	}
	void testRemoveShelter() {
		assertEquals(1, service.removeShelter(1));
	}
}
