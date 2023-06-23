package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.java.servlet.service.NoticeService;
import com.java.servlet.service.impl.NoticeServiceImpl;

class NoticeServletServiceImplTest {
	private final NoticeService service = NoticeServiceImpl.getInstance();
	@Test
	void testGetNotice() {
		String admin_name="관리자";
		assertNotEquals(null, service.getNotice(admin_name));
		System.out.println(service.getNotice(admin_name));
	}

}
