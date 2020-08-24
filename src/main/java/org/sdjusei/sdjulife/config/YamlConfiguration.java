package org.sdjusei.sdjulife.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Objects;

/**
 * yaml配置类，解决无法注解加载自定义yaml配置文件的问题
 *
 * @author zcz
 * @date 2020/08/14
 */
@Configuration
public class YamlConfiguration {
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ClassPathResource("common.yaml"));
		propertySourcesPlaceholderConfigurer.setProperties(Objects.requireNonNull(yaml.getObject()));
		return propertySourcesPlaceholderConfigurer;
	}
}
