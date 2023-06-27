package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;





import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.Favorite_S_Service;
import com.java.servlet.service.impl.Favorite_S_ServiceImpl;
import com.java.servlet.util.Criteria;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.Favorite_S_VO;

class Favorite_S_ServletServiceImplTest {
	
private Favorite_S_Service service = Favorite_S_ServiceImpl.getInstance();
	
	@Test  @Ignore
	void testGetSelectShelterBoard() {
		List<Favorite_S_VO> slist = service.getShelterBoard();
		
		assertNotEquals(null, slist);
		System.out.println("service test");
		System.out.println(slist);
	}

	@Test @Ignore
	void testGetCountShelterBoard() {
		int sresult = service.getCountShelterBoard();
		assertNotEquals(0, sresult);
		
		System.out.println("totalCount : "+sresult);
	}
	
	
	@Test @Ignore
	void testGetWithPetBoardByPage() {
		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
		PageMaker pageMaker = new PageMaker
				(cri, 101); // cri, totalCount=100
		pageMaker.setDisplayPageAmount(10);
		System.out.println(pageMaker);
		
		List<Favorite_S_VO> boardList  = service.getShelterBoardByPage(pageMaker);
		System.out.println(boardList);
		assertNotEquals(null, boardList);
		
		System.out.println("boardList per Page : "+boardList);
	}
	
	//---------------------------------------------------------------
	
	
	
}
