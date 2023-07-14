package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.CommunityDAO;
import com.java.servlet.dao.impl.CommunityDAOImpl;
import com.java.servlet.service.CommunityService;
import com.java.servlet.service.impl.CommunityServiceImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;

class CommunityServletDAOImplTest {
	private final CommunityDAO dao = CommunityDAOImpl.getInstance();
		@Test
		void testSelectCommunity() {
	
			List<CommunityVO> list = dao.selectAllCommunity();
			
			assertNotEquals(null, list);
			
			System.out.println(list);
		}

		@Test 
		void testSelectCountAllCommunity() {
			int result = dao.selectCountAllCommunity();
			assertNotEquals(0, result);
			
			System.out.println("totalCount : "+result);
		}
		
		@Test @Ignore
		void testSelectAllBoardByPage() {
			
			Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
			PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
			pageMaker.setDisplayPageAmount(10);
			System.out.println(pageMaker);
			
			List<CommunityVO> communityList  = dao.selectAllCommunityByPage(pageMaker);
			System.out.println(communityList);
			assertNotEquals(null, communityList);
			
			System.out.println("communityList per Page : "+communityList);
		}

}
