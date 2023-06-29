package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;




import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;


import com.java.servlet.dao.ShelterDAO;

import com.java.servlet.dao.impl.ShelterDAOImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.ShelterVO;

class ShelterServletDAOImplTest {
	
	private final ShelterDAO dao = ShelterDAOImpl.getInstance();
	
	
	@Test @Ignore
	void testSelectShelter() {
		int shelter_no = 1;
		
		assertNotEquals(0,dao.selectShelter(shelter_no));
		System.out.println(dao.selectShelter(shelter_no));
	}
	
	
		
	
	
//	@Test @Ignore
//	void testSelectsAllBoard() {
//	
//		List<ShelterVO> list = dao.selectAllBoard();
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
//		List<ShelterVO> boardList  = dao.selectAllBoardByPage(pageMaker);
//		System.out.println(boardList);
//		assertNotEquals(0, boardList);
//	
//		
//		System.out.println("boardList per Page : "+boardList);
//	}
	

	
	

}
