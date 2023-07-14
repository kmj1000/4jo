package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.LoginDAO;
import com.java.servlet.dao.impl.LoginDAOImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MembersVO;

class LoginServletDAOImplTest {

	LoginDAO dao = LoginDAOImpl.getInstance();
	LoginDAO dao2 = LoginDAOImpl.getInstance();
	
	@Test @Ignore
	void testReference() {
		assertEquals(dao, dao2);
	}
	@Test 
	void testSelectMembersByIdAndPwd() {
		MembersVO vo = new MembersVO();
		vo.setEmail("minju03@babo.com");
		vo.setPwd( "qkqh" );
		
		dao.selectMembersByIdAndPwd(vo);
		assertEquals(vo, vo);
		
		System.out.println("여기- "+vo);
	}

}
