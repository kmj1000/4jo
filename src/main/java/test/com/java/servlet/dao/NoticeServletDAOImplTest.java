package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.NoticeDAO;
import com.java.servlet.dao.impl.NoticeDAOImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.NoticeVO;

class NoticeServletDAOImplTest {
	private final NoticeDAO dao = NoticeDAOImpl.getInstance();
	@Test
	void testSelectNotice() {
		List<NoticeVO> list = dao.selectAllNotice();
		
		assertNotEquals(null, list);
		
		System.out.println(list);
	}

	@Test 
	void testSelectCountAllNotice() {
		int result = dao.selectCountAllNotice();
		assertNotEquals(0, result);
		
		System.out.println("totalCount : "+result);
	}
	
	@Test @Ignore
	void testSelectAllBoardByPage() {
		
		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
		PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
		pageMaker.setDisplayPageAmount(10);
		System.out.println(pageMaker);
		
		List<NoticeVO> NoticeList  = dao.selectAllNoticeByPage(pageMaker);
		System.out.println(NoticeList);
		assertNotEquals(null, NoticeList);
		
		System.out.println("NoticeList per Page : "+NoticeList);
	}

}
