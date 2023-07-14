package com.spring.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.domain.MemberDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberApiMapperTest {
	@Setter(onMethod_=@Autowired)
	MemberApiMapper mapper;
	@Test
	public void testSelectMemberList() {
		List<MemberDTO> list=mapper.selectMemberList();
		log.info("list - "+list);
		assertNotNull(list);
	}

}
