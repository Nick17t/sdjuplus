package org.sdjusei.sdjulife.interceptor;

import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.exception.CommonException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一认证系统拦截器
 *
 * @author zcz
 * @date 2020/08/09
 */
@Component
public class UnifiedSysInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String cookie = request.getHeader("Cookie");
		if(cookie==null||"".equalsIgnoreCase(cookie))
			throw new CommonException(ResultEnum.SCHOOL_SYS_NO_LOGIN_INFO);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

	}
}
