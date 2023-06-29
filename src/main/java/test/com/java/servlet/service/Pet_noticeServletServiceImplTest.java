package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;





import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.Pet_noticeService;
import com.java.servlet.service.impl.Pet_noticeServiceImpl;
import com.java.servlet.util.Criteria;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.Pet_noticeVO;

class Pet_noticeServletServiceImplTest {
	
private Pet_noticeService service = Pet_noticeServiceImpl.getInstance();
	
//	@Test  @Ignore
//	void testGetSelectPet_noticeBoard() {
//		List<Pet_noticeVO> list = service.getAllBoard();
//		
//		assertNotEquals(null, list);
//		System.out.println("service test");
//		System.out.println(list);
//	}
//
//	@Test @Ignore
//	void testGetCountPet_noticeBoard() {
//		int result = service.getCountAllBoard();
//		assertNotEquals(0, result);
//		
//		System.out.println("totalCount : "+result);
//	}
//	
//	
//	@Test @Ignore
//	void testGetPet_noticeBoardByPage() {
//		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
//		PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
//		pageMaker.setDisplayPageAmount(10);
//		System.out.println(pageMaker);
//		
//		List<Pet_noticeVO> boardList  = service.getAllBoardByPage(pageMaker);
//		System.out.println(boardList);
//		assertNotEquals(null, boardList);
//		
//		System.out.println("boardList per Page : "+boardList);
//	}
	
	//---------------------------------------------------------------
	@Test @Ignore
	void testGetPet_notice() {
		int pet_notice_no=1;
		assertNotEquals(null, service.getPet_notice(pet_notice_no));
		System.out.println(service.getPet_notice(pet_notice_no));
	}
	
	
}
