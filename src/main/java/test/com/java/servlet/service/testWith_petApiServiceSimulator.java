package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.java.servlet.service.With_petApiService;
import com.java.servlet.service.impl.With_petApiServiceImpl;
import com.java.servlet.vo.Favorite_W_VO;
import com.java.servlet.vo.With_petVO;


class testWith_petApiServiceSimulator {
	private final With_petApiService service = With_petApiServiceImpl.getInstance();
Date favoritew_reg_date = new Date(System.currentTimeMillis());
	@Test
	void testRegisterShelter() {
		Favorite_W_VO vo2 = new Favorite_W_VO();
		With_petVO vo = new With_petVO();
		vo2.setFavoritew_no(1);
		vo2.setNickname("bb");
		vo2.setFavoritew_reg_date(favoritew_reg_date);
		vo.setWith_pet_no(2);
		vo.setBuilding("bb");
		vo.setRoad("bb");
		vo.setTel("bb");
		assertEquals(1,service.registerWith_pet(vo));	
	}
	void testRemoveWith_pet() {
		assertEquals(1, service.removeWith_pet(1));
	}
}
