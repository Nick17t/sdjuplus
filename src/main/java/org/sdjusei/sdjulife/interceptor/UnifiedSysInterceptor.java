package org.sdjusei.sdjulife.interceptor;

import org.jsoup.Jsoup;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.exception.CommonException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一认证系统拦截器
 *
 * @author zcz
 * @date 2020/08/09
 */
@Component
public class UnifiedSysInterceptor implements HandlerInterceptor {

	@Value("${unifiedSys.ehallUrl}")
	private String ehallUrl;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//如果没有统一认证系统的cookie，视为没有登录统一认证系统
		Cookie[] cookiesArray = request.getCookies();
		Map<String, String> cookies = new HashMap<>();
		for (Cookie c : cookiesArray) {
			cookies.put(c.getName(), c.getValue());
		}
		if (cookies.get("iPlanetDirectoryPro") == null || cookies.get("CASTGC") == null)
			throw new CommonException(ResultEnum.SCHOOL_SYS_NOT_LOGIN);

		//如果尝试连接ehall被要求跳转到登录页面，那么视为统一认证系统登录状态失效
		String location = Jsoup.connect(ehallUrl)
				.followRedirects(false)
				.cookies(cookies)
				.execute()
				.header("Location");
		if (location != null)
			throw new CommonException(ResultEnum.SCHOOL_SYS_NOT_LOGIN);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

	}
}
