package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;



import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.MypageService;
import com.java.servlet.service.impl.MypageServiceImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.MembersVO;

class MypageServletServiceImplTest {
	
private MypageService service = MypageServiceImpl.getInstance();
	
	@Test  @Ignore
	void testGetSelectAllBoard() {
		List<MembersVO> slist = service.getAllBoard();
		
		assertNotEquals(null, slist);
		System.out.println("service test");
		System.out.println(slist);
	}

	@Test @Ignore
	void testGetCountAllBoard() {
		int sresult = service.getCountAllBoard();
		assertNotEquals(0, sresult);
		
		System.out.println("totalCount : "+sresult);
	}
	
	
	@Test @Ignore
	void testGetAllBoardByPage() {
		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
		PageMaker pageMaker = new PageMaker
				(cri, 101); // cri, totalCount=100
		pageMaker.setDisplayPageAmount(10);
		System.out.println(pageMaker);
		
		List<MembersVO> boardList  = service.getAllBoardByPage(pageMaker);
		System.out.println(boardList);
		assertNotEquals(null, boardList);
		
		System.out.println("boardList per Page : "+boardList);
	}
	
	//---------------------------------------------------------------
	
	
	
}
