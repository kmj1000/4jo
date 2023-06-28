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
		List<MembersVO> list = dao.selectAllBoard();
		
		assertNotEquals(null, list);		
		System.out.println(list);
	}
	

	
	

}
