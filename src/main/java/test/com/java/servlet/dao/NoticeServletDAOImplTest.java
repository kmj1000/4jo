package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.java.servlet.dao.CommunityDAO;
import com.java.servlet.dao.NoticeDAO;
import com.java.servlet.dao.impl.CommunityDAOImpl;
import com.java.servlet.dao.impl.NoticeDAOImpl;

class NoticeServletDAOImplTest {
	private final NoticeDAO dao = NoticeDAOImpl.getInstance();
	@Test
	void testSelectNotice() {
		String admin_name="관리자";
		assertNotEquals(null, dao.selectNotice(admin_name));
		System.out.println(dao.selectNotice(admin_name));
	}

}
