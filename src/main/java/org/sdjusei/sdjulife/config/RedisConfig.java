package org.sdjusei.sdjulife.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 *
 * @author zcz
 * @date 2020/08/24
 */
@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setDefaultSerializer(new Gson2JsonRedisSerializer<>());
		return redisTemplate;
	}

	/**
	 * Gson序列化器类，替换默认的序列化方法
	 * @param <T> 泛型
	 */
	static class Gson2JsonRedisSerializer<T> implements RedisSerializer<T> {

		private final Gson gson = new Gson();

		@Override
		public byte[] serialize(T t) throws SerializationException {
			if (t == null) {
				return new byte[0];
			}
			try {
				return this.gson.toJson(t).getBytes();
			} catch (Exception ex) {
				throw new SerializationException("Could not write JSON: " + ex.getMessage(), ex);
			}
		}

		@Override
		public T deserialize(byte[] bytes) throws SerializationException {
			if (bytes == null || bytes.length == 0)
				return null;
			try {
				return this.gson.fromJson(new String(bytes), new TypeToken<T>() {
				}.getType());
			} catch (Exception ex) {
				throw new SerializationException("Could not read JSON: " + ex.getMessage(), ex);
			}
		}
	}
}
