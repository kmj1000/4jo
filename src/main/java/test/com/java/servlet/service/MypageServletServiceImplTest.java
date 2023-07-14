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
	
//	@Test  @Ignore
//	void testGetSelectAllBoard() {
//		int m_no= 1;
//		MembersVO vo = service.selectMypage(m_no);
//		
//		assertNotEquals(null, vo);
//		System.out.println("service test");
//		System.out.println(vo);
//	}

}
