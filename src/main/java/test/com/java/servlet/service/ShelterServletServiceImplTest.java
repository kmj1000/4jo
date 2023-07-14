package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;





import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.ShelterService;
import com.java.servlet.service.impl.ShelterServiceImpl;
import com.java.servlet.util.Criteria;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.ShelterVO;

class ShelterServletServiceImplTest {
	
private ShelterService service = ShelterServiceImpl.getInstance();
	
	@Test  @Ignore
	void testGetSelectShelterBoard() {
		List<ShelterVO> list = service.getAllBoard();
		
		assertNotEquals(null, list);
		System.out.println("service test");
		System.out.println(list);
	}

	@Test @Ignore
	void testGetCountShelterBoard() {
		int result = service.getCountAllBoard();
		assertNotEquals(0, result);
		
		System.out.println("totalCount : "+result);
	}
	
	
	@Test @Ignore
	void testGetShelterBoardByPage() {
		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
		PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
		pageMaker.setDisplayPageAmount(10);
		System.out.println(pageMaker);
		
		List<ShelterVO> boardList  = service.getAllBoardByPage(pageMaker);
		System.out.println(boardList);
		assertNotEquals(null, boardList);
		
		System.out.println("boardList per Page : "+boardList);
	}
	
	//---------------------------------------------------------------
	void testGetShelter(){
		int shelter_no =1;
		
		assertNotEquals(null, service.getShelter(shelter_no));
		System.out.println(service.getShelter(shelter_no));
	}
	
	
}
