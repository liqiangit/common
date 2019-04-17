package com.liqiang.common.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.liqiang.common.cache.redis.RedisUtil;

@Component
public class RedisSequence implements Sequence{
	@Autowired
	private RedisUtil redisUtil;
	@Override
	public Long nextval(String sequenceName) {
		return redisUtil.incr(sequenceName, 1l);
	}

}
