package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.LoginService;
import com.java.servlet.service.impl.LoginServiceImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MembersVO;

class LoginServletServiceImplTest {

	private LoginService service = LoginServiceImpl.getInstance();
	
	@Test
	void testSelectMembersByIdAndPwd() {
		MembersVO vo = new MembersVO();
		vo.setEmail("minju03@babo.com");
		vo.setPwd("qkqh" );
		
		service.getMembersByIdAndPwd(vo);
		assertEquals(vo, vo);
		
		System.out.println("여기 " + vo);
	}

}
