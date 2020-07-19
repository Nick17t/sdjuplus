package org.sdjusei.sdjulife;

import org.junit.jupiter.api.Test;
import org.sdjusei.sdjulife.domain.UserLoginMsg;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
//@WebMvcTest
class SdjulifeApplicationTests {

//	@Resource
//	private MockMvc mockMvc;

	@Resource
	public UserLoginMsg userLoginMsg;

	@Test
	void contextLoads() {
		userLoginMsg.setCode("123");
		userLoginMsg.setPlatform("wx");
		System.out.println(userLoginMsg);
	}

}
