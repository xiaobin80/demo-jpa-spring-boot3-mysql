package com.example.config;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {
	 private LettuceConnectionFactory myLettuceConnectionFactory;

	    @Bean
	    public RedisTemplate<String, Serializable> redisTemplate() {

	        RedisTemplate<String, Serializable> template = new RedisTemplate<>();

	        template.setKeySerializer(new StringRedisSerializer());

	        //template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	        template.setValueSerializer(new StringRedisSerializer());

	        template.setConnectionFactory(myLettuceConnectionFactory);

	        return template;
	    }
}
