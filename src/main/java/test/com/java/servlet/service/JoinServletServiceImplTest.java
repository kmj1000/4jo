package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.JoinService;
import com.java.servlet.service.impl.JoinServiceImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MembersVO;

class JoinServletServiceImplTest {
	JoinService service = JoinServiceImpl.getInstance();
	
	@Test @Ignore
	void testRegisterMembers() {
		MembersVO vo = new MembersVO();
		vo.setNickname("여니");
		vo.setEmail("su@yeon.com");
		vo.setPwd("susu");
		vo.setName( "강수연" );
		vo.setPhone(Integer.parseInt("01012844677"));
		
		assertEquals(1, service.registerMembers(vo));  
		
	}
}
