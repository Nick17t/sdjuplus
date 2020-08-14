package org.sdjusei.sdjulife;

import org.junit.jupiter.api.Test;
import org.sdjusei.sdjulife.domain.Course;
import org.sdjusei.sdjulife.domain.Exam;
import org.sdjusei.sdjulife.domain.Score;
import org.sdjusei.sdjulife.service.CourseService;
import org.sdjusei.sdjulife.service.ExamService;
import org.sdjusei.sdjulife.service.SchoolSysLoginService;
import org.sdjusei.sdjulife.service.ScoreService;
import org.sdjusei.sdjulife.util.PasswordUtil;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
//@WebMvcTest
class SdjulifeApplicationTests {

//	@Resource
//	private MockMvc mockMvc;

	@Resource
	public SchoolSysLoginService schoolSysLoginService;
	@Resource
	public CourseService courseService;
	@Resource
	public ScoreService scoreService;
	@Resource
	public ExamService examService;

	@Test
	void contextLoads() throws Exception {
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("username", "");
		dataMap = schoolSysLoginService.unifiedLogin(dataMap);
		dataMap.put("password", PasswordUtil.encryptAES("", dataMap.get("aseKey")));
		System.out.println(dataMap);
		dataMap = schoolSysLoginService.unifiedLogin(dataMap);
		System.out.println(dataMap);

//		dataMap.put("iPlanetDirectoryPro","qCiznZprBgZNTvIVuTMri7");
//		dataMap.put("CASTGC","TGT-13925-1MzYGXXBeJFmF90JgPYfanpdscXdN5ICvkjfOOiFNl3ZEkBB6R1597244331398-VnAP-cas");
//		Document location = Jsoup.connect("https://ehall.sdju.edu.cn/")
//				.cookies(dataMap)
//				.get();
//		System.out.println(location);
		List<Course> scheduleTest = courseService.getSchedule(dataMap, "2020", "3");
		System.out.println(scheduleTest);

		List<Score> scoreList = scoreService.getScoreList(dataMap, "2019", "3");
		System.out.println(scoreList);

		List<Exam> examList = examService.getExamList(dataMap, "2019", "3");
		System.out.println(examList);
	}

}
