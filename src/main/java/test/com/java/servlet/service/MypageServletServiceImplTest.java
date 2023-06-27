package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;



import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.MypageService;
import com.java.servlet.service.impl.MypageServiceImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.MembersVO;

class MypageServletServiceImplTest {
	
private MypageService service = MypageServiceImpl.getInstance();
	
	@Test  @Ignore
	void testGetSelectAllBoard() {
		List<MembersVO> slist = service.getAllBoard();
		
		assertNotEquals(null, slist);
		System.out.println("service test");
		System.out.println(slist);
	}


	
}
