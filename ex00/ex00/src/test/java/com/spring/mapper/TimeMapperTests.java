package com.spring.mapper;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class TimeMapperTests {
	
		@Setter(onMethod_ = @Autowired)
		private TimeMapper mapper;
		
		@Test @Ignore
		public void testMapper() {
			log.info("mapper class name - " + mapper.getClass().getName());
			log.info("mapper getRime - " + mapper.getTime());
		}

		@Test
		public void tessGetTime2() {
			assertNotNull(mapper.getClass().getName());
			log.info(mapper.getClass().getName());
			log.info(mapper.getTime2());
		}
}
