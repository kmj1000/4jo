package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;



import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.Favorite_S_DAO;
import com.java.servlet.dao.impl.Favorite_S_DAOImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.Favorite_S_VO;

class Favorite_S_DAOImplTest {
	
	private final Favorite_S_DAO dao = Favorite_S_DAOImpl.getInstance();
	
	@Test @Ignore
	void testSelectShelterBoard() {
		List<Favorite_S_VO> list = dao.selectShelterBoard();
		
		assertNotEquals(null, list);
		
		System.out.println(list);
	}
	

	@Test @Ignore
	void testSelectCountShelterBoard() {
		int result = dao.seletCountShelterBoard();
		assertNotEquals(0, result);
		
		System.out.println("totalCount : "+result);
	}
	
	@Test @Ignore
	void testSelectShelterBoardByPage() {
		
		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
		PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
		pageMaker.setDisplayPageAmount(10);
		System.out.println(pageMaker);
		
		List<Favorite_S_VO> boardList  = dao.selectShelterBoardByPage(pageMaker);
		System.out.println(boardList);
		assertNotEquals(null, boardList);
	
		
		System.out.println("boardList per Page : "+
		boardList);
	}
	

	
	

}
