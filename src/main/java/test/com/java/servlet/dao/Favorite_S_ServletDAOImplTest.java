package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.Favorite_S_DAO;
import com.java.servlet.dao.impl.Favorite_S_DAOImpl;

class Favorite_S_ServletDAOImplTest {
	private final Favorite_S_DAO dao = Favorite_S_DAOImpl.getInstance();
	@Test @Ignore
	void testSelectedFavorite_S() {
		int favorite_shelter_no = 1;
		assertNotEquals(null, dao.selectFavorite_shelter(favorite_shelter_no));
		System.out.println(dao.selectFavorite_shelter(favorite_shelter_no));
	}

}
