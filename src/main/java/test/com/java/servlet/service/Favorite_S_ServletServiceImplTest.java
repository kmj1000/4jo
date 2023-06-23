package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.Favorite_S_Service;
import com.java.servlet.service.impl.Favorite_S_ServiceImpl;

class Favorite_S_ServletServiceImplTest {
	private final Favorite_S_Service service = Favorite_S_ServiceImpl.getInstance();
	@Test@Ignore
	void testGetFavoriteshelter() {
		int favorite_shelter_no = 1;
		assertNotEquals(null, service.getFavorite_shelter(favorite_shelter_no));
		System.out.println(service.getFavorite_shelter(favorite_shelter_no));
	}

}
