package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.CommunityService;
import com.java.servlet.service.impl.CommunityServiceImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;

class CommunityServletServiceImplTest {
	private final CommunityService service = CommunityServiceImpl.getInstance(); 
	@Test
	void testGetAllCommunity() {
		List<CommunityVO> list = service.getAllCommunity();
		
		assertNotEquals(null, list);
		System.out.println("service test");
		System.out.println(list);
	}

	/* @Test @Ignore */
	void testGetCountAllCommunity() {
		int result = service.getCountAllCommunity();
		assertNotEquals(0, result);
		
		System.out.println("totalCount : "+result);
	}
	
	
	@Test @Ignore
	void testGetAllCommunityByPage() {
		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
		PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
		pageMaker.setDisplayPageAmount(10);
		System.out.println(pageMaker);
		
		List<CommunityVO> communityList  = service.getAllCommunityByPage(pageMaker);
		System.out.println(communityList);
		assertNotEquals(null, communityList);
		
		System.out.println("communityList per Page : "+communityList);
	}
}
