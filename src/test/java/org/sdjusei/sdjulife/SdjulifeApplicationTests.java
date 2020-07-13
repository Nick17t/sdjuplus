package org.sdjusei.sdjulife;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

@SpringBootTest
@WebMvcTest
@AutoConfigureRestDocs
class SdjulifeApplicationTests {

	@Resource
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

}
