package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.Favorite_W_DAO;
import com.java.servlet.dao.impl.Favorite_W_DAOImpl;

class Favorite_W_ServletDAOImplTest {


		private final Favorite_W_DAO dao = Favorite_W_DAOImpl.getInstance();
		
		@Test @Ignore
		void testSelectedFavorite_W() {
			int favorite_with_pet_no=1;
			assertNotEquals(null, dao.selectFavorite_with_pet(favorite_with_pet_no));
			System.out.println(dao.selectFavorite_with_pet(favorite_with_pet_no));
		
	}

}
