package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;



import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.With_petDAO;
import com.java.servlet.dao.impl.With_petDAOImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;


import com.java.servlet.vo.With_petVO;

class With_petServletDAOImplTest {
	
	private final With_petDAO dao = With_petDAOImpl.getInstance();
	
	@Test@Ignore
	void testSelectWithpet() {
		int with_pet_no=325;
		assertNotEquals(null, dao.selectWith_pet(with_pet_no));
		System.out.println(dao.selectWith_pet(with_pet_no));
	}
	
//	@Test @Ignore
//	void testSelectsAllBoard() {
//		List<With_petVO> list = dao.selectAllBoard();
//		
//		assertNotEquals(0, list);
//		
//		System.out.println(list);
//	}
//	
//
//	@Test @Ignore
//	void testSelectCountsAllBoard() {
//		int result = dao.seletCountAllBoard();
//		assertNotEquals(0, result);
//		
//		System.out.println("totalCount : "+result);
//	}
//	
//	@Test @Ignore
//	void testSelectsAllBoardByPage() {
//		
//		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
//		PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
//		pageMaker.setDisplayPageAmount(10);
//		System.out.println(pageMaker);
//		
//		List<With_petVO> boardList  = dao.selectAllBoardByPage(pageMaker);
//		System.out.println(boardList);
//		assertNotEquals(0, boardList);
//	
//		
//		System.out.println("boardList per Page : "+boardList);
//	}
	

	
	

}