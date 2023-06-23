package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.Favorite_W_Service;
import com.java.servlet.service.impl.Favorite_W_ServiceImpl;

class Favorite_W_ServletServiceImplTest {
	private final Favorite_W_Service service = Favorite_W_ServiceImpl.getInstance();
	@Test@Ignore
	void testgetFavorite_with_pet() {
		int favorite_with_pet_no=1;
		assertNotEquals(null, service.getFavorite_with_pet(favorite_with_pet_no));
		System.out.println(service.getFavorite_with_pet(favorite_with_pet_no));
	}

}
