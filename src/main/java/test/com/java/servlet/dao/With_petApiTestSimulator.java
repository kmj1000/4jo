package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.With_petApiDAO;
import com.java.servlet.dao.impl.With_petApiDAOImpl;
import com.java.servlet.vo.Favorite_W_VO;

class With_petApiTestSimulator {

	private final With_petApiDAO dao = With_petApiDAOImpl.getInstance();
	Date favoritew_reg_date = new Date(System.currentTimeMillis());
	@Test
	void testInsertWith_pet() {
		Favorite_W_VO vo = new Favorite_W_VO();
		
		vo.setNickname("bb");
		vo.setFavoritew_reg_date(favoritew_reg_date);
		vo.setWith_pet_no(2);
		vo.setBuilding("bb");
		vo.setRoad("bb");
		vo.setTel("bb");
		assertEquals(1,dao.insertWith_petData(vo));
	}
	@Test@Ignore
	void testDeleteWith_pet() {
		assertEquals(1, dao.deleteWith_petData(1));
	}

}

