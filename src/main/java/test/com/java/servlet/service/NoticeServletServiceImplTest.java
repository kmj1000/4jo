package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.java.servlet.service.NoticeService;
import com.java.servlet.service.impl.NoticeServiceImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.NoticeVO;

class NoticeServletServiceImplTest {
	private final NoticeService service = NoticeServiceImpl.getInstance();
	@Test
	void testGetAllNotice() {
		List<NoticeVO> list = service.getAllNotice();
		
		assertNotEquals(null, list);
		System.out.println("service test");
		System.out.println(list);
	}

	/* @Test @Ignore */
	void testGetCountAllNotice() {
		int result = service.getCountAllNotice();
		assertNotEquals(0, result);
		
		System.out.println("totalCount : "+result);
	}
	
	
	@Test 
	void testGetAllNoticeByPage() {
		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
		PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
		pageMaker.setDisplayPageAmount(10);
		System.out.println(pageMaker);
		
		List<NoticeVO> noticeList  = service.getAllNoticeByPage(pageMaker);
		System.out.println(noticeList);
		assertNotEquals(null, noticeList);
		
		System.out.println("noticeList per Page : "+noticeList);
	}

}
