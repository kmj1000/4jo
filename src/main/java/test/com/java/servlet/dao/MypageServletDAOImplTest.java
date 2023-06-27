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
	
	

	
	@Test @Ignore
	void testSelectAllBoardByPage() {
		
		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
		PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
		pageMaker.setDisplayPageAmount(10);
		System.out.println(pageMaker);
		
		List<MembersVO> boardList  = dao.selectAllBoardByPage(pageMaker);
		System.out.println(boardList);
		assertNotEquals(null, boardList);
		
		System.out.println("boardList per Page : "+boardList);
	}

}
