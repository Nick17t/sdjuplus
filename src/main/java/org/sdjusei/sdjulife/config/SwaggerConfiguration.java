package org.sdjusei.sdjulife.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * knife4j配置类
 *
 * @author zhaochenzhi
 * @date 2020/07/13
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
	public static final String SWAGGER_SCAN_BASE_PACKAGE = "org.sdjusei.sdjulife.controller";
	public static final String VERSION = "0.0.1";

	@Bean(value = "defaultApi2")
	public Docket defaultApi2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("电机生活小程序") //设置文档的标题
				.contact(new Contact("电机生活小程序开发组", "无", "无"))
				.description("电机生活小程序API接口文档") // 设置文档的描述
				.version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
				//.termsOfServiceUrl("http://www.baidu.com") // 设置文档的License信息->1.3 License information
				.build();
	}
}
