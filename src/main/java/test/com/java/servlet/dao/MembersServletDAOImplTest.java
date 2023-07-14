package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.MembersDAO;
import com.java.servlet.dao.impl.MembersDAOImpl;

class MembersServletDAOImplTest {

	MembersDAO dao = new MembersDAOImpl();
	
	@Test 
	void testSelectMemberList() throws ClassNotFoundException, SQLException, NamingException {
		// assertArrayEquals(a, b)
		// assertEquals(a, b)
		// assertSame(a,b)
		// assertTrue(a)
		// assertFalse(a)
		// assertNotNull(a)
		//DBCP2Util.testInit();
		assertNotNull(dao.selectMembersList());
		System.out.println(dao.selectMembersList());
	}
}
