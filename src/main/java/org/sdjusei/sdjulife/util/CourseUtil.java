package org.sdjusei.sdjulife.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.sdjusei.sdjulife.domain.Course;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 课程工具类，获取课表
 *
 * @author zcz
 * @date 2020/07/17
 * @deprecated 弃用了
 */
@Component
public class CourseUtil {
	public String loginUrl = "https://xjwgl.sdju.edu.cn/jwglxt/xtgl/login_slogin.html?time=" + System.currentTimeMillis();
	public String courseListRequestUrl = "https://xjwgl.sdju.edu.cn/jwglxt/kbcx/xskbcx_cxXsKb.html?gnmkdm=N2151";

//	public static void trustEveryone() throws Exception {
//		HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
//		SSLContext context = SSLContext.getInstance("TLS");
//		context.init(null, new X509TrustManager[]{new X509TrustManager() {
//			public void checkClientTrusted(X509Certificate[] chain, String authType) {
//			}
//
//			public void checkServerTrusted(X509Certificate[] chain, String authType) {
//			}
//
//			public X509Certificate[] getAcceptedIssuers() {
//				return new X509Certificate[0];
//			}
//		}}, new SecureRandom());
//		HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
//	}


//	/**
//	 * @param stuId    学号
//	 * @param password 统一验证/教务系统密码
//	 * @param year     学年，以开始的那一年为准，如2019-2020学年的对应参数为2019
//	 * @param term     第一学期的term为3，第二学期的term为12（各个学年待确认）
//	 * @return 返回一个JSON格式的字符串
//	 */
//	public String getCourseListString(String stuId, String password, String year, String term) throws Exception {
//		trustEveryone();
//		Map<String, String> map = new HashMap<>();
//		map.put("yhm", stuId);
//		map.put("mm", password);
//		Connection.Response response = Jsoup
//				.connect(loginUrl)
//				.data(map)
//				.method(Connection.Method.POST)
//				.execute();
//
//		map.put("xnm", year);
//		map.put("xqm", term);
//		response = Jsoup
//				.connect(courseListRequestUrl)
//				.data(map)
//				.cookies(response.cookies())
//				.ignoreContentType(true)
//				.method(Connection.Method.POST)
//				.execute();
//		return response.body();
//	}

//	/**
//	 * @param courseString 从教务系统获得的原始课表json字符串
//	 * @return 返回课表实体类Course的List
//	 */
//	public List<Course> getCourseList(String courseString) throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode jsonNode = mapper.readTree(courseString);
//		JsonNode kbList = jsonNode.findValue("kbList");
//		Iterator<JsonNode> elements = kbList.elements();
//		List<Course> courseList = new ArrayList<>();
//		while (elements.hasNext()) {
//			JsonNode node = elements.next();
//			Course c = mapper.treeToValue(node, Course.class);
//			c = checkMark(c);
//			courseList.add(c);
//		}
//		return courseList;
//	}
//
//	public Course checkMark(Course course) {
//		String zcd = course.getBeginAndEndWeeks();
//		for (int i = zcd.length() - 1; i >= 0; i--) {
//			if (zcd.charAt(i) == '单') {
//				course.setMark("1");
//				break;
//			} else if (zcd.charAt(i) == '双') {
//				course.setMark("2");
//				break;
//			}
//			course.setMark("0");
//		}
//		return course;
//	}

//	@Test
//	public void test() throws Exception {
//		String courseString = getCourseListString("", "", "2019", "3");
//		List<Course> courseList = getCourseList(courseString);
//		for (Course c : courseList)
//			System.out.println(c);
//	}
}
