package com.liqiang.common.cache.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private Cache cache;

	@Test
	public void test() {
		cacheManager.getCache("system").put("test", "test");
		SimpleValueWrapper wrapper = (SimpleValueWrapper) cacheManager.getCache("system").get("test");
		System.err.println(wrapper.get());
		// org.springframework.cache.support.SimpleValueWrapper@6cbd0674
	}

	@Test
	public void testCache() {
		cache.put("testCache", "testCache");
		SimpleValueWrapper wrapper = (SimpleValueWrapper) cache.get("testCache");
		System.err.println(cache.get("testCache"));
		// org.springframework.cache.support.SimpleValueWrapper@6cbd0674
	}

	@Test
	public void testRedis() {
		redisTemplate.opsForValue().setIfAbsent("test2", "test2");
		System.err.println(redisTemplate.opsForValue().get("test2"));
	}

	@Test
	public void testRedisUtil() {
		redisUtil.set("test3", "test3");
		System.err.println(redisTemplate.opsForValue().get("test3"));
	}
}
