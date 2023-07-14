package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.ShelterApiDAO;
import com.java.servlet.dao.impl.ShelterApiDAOImpl;
import com.java.servlet.vo.Favorite_S_VO;
import com.java.servlet.vo.ShelterVO;

class ShelterApiDAOImplSimulator {
	private final ShelterApiDAO dao = ShelterApiDAOImpl.getInstance();
	Date favorites_reg_date = new Date(System.currentTimeMillis());
	@Test@Ignore
	void testInsertShelter() {
		Favorite_S_VO vo2 = new Favorite_S_VO();
		ShelterVO vo = new ShelterVO();
		vo2.setNickname("aa");
		vo2.setFavorites_reg_date(favorites_reg_date);
		vo.setShelter_no(2);
		vo.setCareNm("bb");
		vo.setCareAddr("bb");
		vo.setCareTel("bb");
		assertEquals(1,dao.insertShelterData(vo));
	}
	@Test@Ignore
	void testDeleteShelter() {
		assertEquals(1, dao.deleteShelterData(1));
	}
}
