package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.java.servlet.service.MypageService;
import com.java.servlet.service.impl.MypageServiceImpl;

class MypageServletServiceImplTest {

	private final MypageService service = MypageServiceImpl.getInstance(); 
	@Test
	void test() {
		String nickname = "민주";
		assertNotEquals(null, service.getMypage(nickname));
		System.out.println(service.getMypage(nickname));
	}

}
