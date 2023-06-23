package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.CommunityService;
import com.java.servlet.service.impl.CommunityServiceImpl;

class CommunityServletServiceImplTest {
	private final CommunityService service = CommunityServiceImpl.getInstance(); 
	@Test
	void testGetCommunity() {
		int c_no=1;
		assertNotEquals(null, service.getCommunity(c_no));
		System.out.println(service.getCommunity(c_no));
	}

}
