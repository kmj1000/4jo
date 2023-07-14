package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.JoinDAO;
import com.java.servlet.dao.impl.JoinDAOImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MembersVO;

class JoinServletDAOImplTest {
	JoinDAO dao = JoinDAOImpl.getInstance();

	@Test
	void testInsertMember() {
		MembersVO vo = new MembersVO();
		vo.setNickname("예찌");
		vo.setEmail("gang45@msi.com");
		vo.setPwd(SHAEncodeUtil.encodeSha("jem04") );
		vo.setName("김경미");
		vo.setPhone(Integer.parseInt("01012194677"));
		assertEquals(1, dao.insertMembers(vo));

	}
	
	
}
