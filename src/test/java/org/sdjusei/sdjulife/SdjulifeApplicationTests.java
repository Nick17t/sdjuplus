package org.sdjusei.sdjulife;

import org.junit.jupiter.api.Test;
import org.sdjusei.sdjulife.util.SchoolSysAccessUtil;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
//@WebMvcTest
class SdjulifeApplicationTests {

//	@Resource
//	private MockMvc mockMvc;

	@Resource
	public SchoolSysAccessUtil schoolSysAccessUtil;

	@Test
	void contextLoads() throws Exception {
//		Map<String, String> map = schoolSysAccessUtil.unifiedLogin();
//		System.out.println(map);
//		map = schoolSysAccessUtil.emsLogin(map);
//		System.out.println(map);
//		System.out.println(schoolSysAccessUtil.getCourseListString(map));
	}

}
