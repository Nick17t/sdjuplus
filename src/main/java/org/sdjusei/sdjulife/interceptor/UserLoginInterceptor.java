package org.sdjusei.sdjulife.interceptor;

import org.sdjusei.sdjulife.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 小程序登录拦截器，用于校验用户的登录状态是否有效
 *
 * @author zcz
 * @date 2020/07/18
 */
@Component
public class UserLoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		Cookie[] cookies = request.getCookies();
		String token = null;
		for (Cookie c : cookies) {
			if ("Token".equalsIgnoreCase(c.getName())) {
				token = c.getValue();
				break;
			}
		}

		//TODO 开发模式下，没有token也放行，上线前应去除
		if (token == null)
			return true;

		//如果验证失败会抛出异常，被异常处理器拦截处理
		TokenUtil.verifyJwtToken(token);

		//验证成功则放行
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

	}
}
