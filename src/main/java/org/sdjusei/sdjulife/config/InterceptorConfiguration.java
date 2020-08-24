package org.sdjusei.sdjulife.config;

import org.sdjusei.sdjulife.interceptor.UnifiedSysInterceptor;
import org.sdjusei.sdjulife.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 拦截器配置类
 *
 * @author zcz
 * @date 2020/07/24
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

	@Resource
	private UserLoginInterceptor userLoginInterceptor;
	@Resource
	private UnifiedSysInterceptor unifiedSysInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//小程序登录拦截器
		registry.addInterceptor(userLoginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/**/login")
				.excludePathPatterns("/school-notice/**");
		//统一认证系统登录拦截器
		registry.addInterceptor(unifiedSysInterceptor)
				.addPathPatterns("/card/**")
				.addPathPatterns("/course/**")
				.addPathPatterns("/exam/**")
				.addPathPatterns("/library/borrowed")
				.addPathPatterns("/score/**");
	}
}
