package com.spring.test;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data //데이터로 하면 한번에 가넝
@AllArgsConstructor
public class Chef {
	private People people;

}
