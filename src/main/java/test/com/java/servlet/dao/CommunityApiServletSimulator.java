package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.java.servlet.dao.CommunityApiDAO;
import com.java.servlet.dao.JoinDAO;
import com.java.servlet.dao.impl.CommunityApiDAOImpl;
import com.java.servlet.dao.impl.JoinDAOImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.MembersVO;

class CommunityApiServletSimulator {
	CommunityApiDAO dao =CommunityApiDAOImpl.getInstance();
	Date date = new Date(System.currentTimeMillis());
	@Test
	void testInsertCommunity() {
	
	CommunityVO vo = new CommunityVO();
	vo.setC_no(1);
	vo.setNickname("aa");
	vo.setTitle("asdf" );
	vo.setContent("김경미");
	vo.setReg_date(date);
	assertNotEquals(null, dao.insertCommunity(vo));
	System.out.println(dao.insertCommunity(vo));
	}
}
