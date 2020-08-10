package org.sdjusei.sdjulife.service;

import org.sdjusei.sdjulife.domain.Course;
import org.sdjusei.sdjulife.util.SchoolSysAccessUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程服务，用于获取课表
 *
 * @author zcz
 * @date 2020/07/17
 */
@Service
public class CourseService {

	@Resource
	private SchoolSysAccessUtil schoolSysAccessUtil;

	public List<Course> getSchedule(String password) {
		List<Course> courseList = new ArrayList<>();
		return courseList;
	}
}
