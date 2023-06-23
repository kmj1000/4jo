package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.java.servlet.dao.CommunityDAO;
import com.java.servlet.dao.impl.CommunityDAOImpl;
import com.java.servlet.service.CommunityService;
import com.java.servlet.service.impl.CommunityServiceImpl;

class CommunityServletDAOImplTest {
	private final CommunityDAO dao = CommunityDAOImpl.getInstance();
	@Test
	void testSelectCommunity() {
		int c_no=1;
		assertNotEquals(null, dao.selectCommunity(c_no));
		System.out.println(dao.selectCommunity(c_no));
	}

}
