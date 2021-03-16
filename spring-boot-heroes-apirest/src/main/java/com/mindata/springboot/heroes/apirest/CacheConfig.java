package com.mindata.springboot.heroes.apirest;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfig {
	
	@Bean
	public CacheManager getManager() {
	return new ConcurrentMapCacheManager("heroes");
	}
	
}
