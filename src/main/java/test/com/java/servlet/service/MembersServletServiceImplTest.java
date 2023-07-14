package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.java.servlet.service.MembersService;
import com.java.servlet.service.impl.MembersServiceImpl;

class MembersServletServiceImplTest {

	MembersService service = new MembersServiceImpl();

	@Test
	void testGetMembersList() {
		assertNotNull(service.getMembersList());
	}
}
