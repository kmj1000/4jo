package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;





import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.With_petService;
import com.java.servlet.service.impl.With_petServiceImpl;
import com.java.servlet.util.Criteria;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.With_petVO;

class With_petServletServiceImplTest {
	
private With_petService service = With_petServiceImpl.getInstance();
	
//	@Test  @Ignore
//	void testGetSelectWith_petBoard() {
//		List<With_petVO> list = service.getAllBoard();
//		
//		assertNotEquals(null, list);
//		System.out.println("service test");
//		System.out.println(list);
//	}
//
//	@Test @Ignore
//	void testGetCountWithPetBoard() {
//		int result = service.getCountAllBoard();
//		assertNotEquals(0, result);
//		
//		System.out.println("totalCount : "+result);
//	}
//	
//	
//	@Test @Ignore
//	void testGetWith_petBoardByPage() {
//		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
//		PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
//		pageMaker.setDisplayPageAmount(10);
//		System.out.println(pageMaker);
//		
//		List<With_petVO> boardList  = service.getAllBoardByPage(pageMaker);
//		System.out.println(boardList);
//		assertNotEquals(null, boardList);
//		
//		System.out.println("boardList per Page : "+boardList);
//	}
//	
//	//---------------------------------------------------------------
	@Test@Ignore
	void testGetWith_pet() {
		int with_pet_no = 325;
		assertNotEquals(null,service.getWith_pet(with_pet_no));
		System.out.println(service.getWith_pet(with_pet_no));
	}
	
}
