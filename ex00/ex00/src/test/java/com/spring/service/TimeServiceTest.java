package com.spring.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.service.TimeService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class TimeServiceTest {

	@Setter(onMethod_ = @Autowired)
	TimeService service;
	
	@Test
	public void testGetTime2() {
		assertNotNull(service.getTime2());
		log.info("service.getTime2() - "+service.getTime2());
	}

}
