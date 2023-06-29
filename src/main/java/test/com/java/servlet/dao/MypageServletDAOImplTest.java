package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.MypageDAO;
import com.java.servlet.dao.impl.MypageDAOImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.MembersVO;

class MypageServletDAOImplTest {
	
	private final MypageDAO dao = MypageDAOImpl.getInstance();
	

	@Test @Ignore
	void testSelectAllBoard() {
		String email="";
		MembersVO vo = dao.selectMypage(email);
		
		assertNotEquals(0, vo);				
		System.out.println(vo);
	}
//	
//	@Test @Ignore
//	void testSelectAllBoard() {
//		String nickname = null;
//		MembersVO vo = dao.selectMypage(nickname);
//		
//		assertNotEquals(null, vo);		
//		System.out.println(vo);
//	}
	
//	@Test @Ignore
//	void testselectAllBoard() {
//		int m_no = 0;
//		List<MembersVO> vo = dao.selectMypage(m_no);
//		
//		assertNotEquals(null, vo);		
//		System.out.println(vo);
//	}
//	
	

}
