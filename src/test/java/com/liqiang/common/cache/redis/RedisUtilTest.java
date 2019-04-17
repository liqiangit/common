package com.liqiang.common.cache.redis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {
	@Autowired
	private RedisUtil redisUtil;
	@Test
	public void testExpire() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExpire() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStringObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStringObjectLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncr() {
		final Map<String, String> map = new HashMap<String, String>();
		ExecutorService cachedThreadPool = Executors.newFixedThreadPool(50);
		for (int i = 0; i < 10000; i++) {
			cachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					long total=redisUtil.incr("test100", 1l);
					if (map.containsKey(total + "")) {
						System.err.println(total);
					}
					System.out.println(total);
					map.put(total + "", null);
				
				}
			});
		}
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDecr() {
		long total=redisUtil.decr("test100", 5l);
		System.out.println(total);
	}

	@Test
	public void testHget() {
		fail("Not yet implemented");
	}

	@Test
	public void testHmget() {
		fail("Not yet implemented");
	}

	@Test
	public void testHmsetStringMapOfStringObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testHmsetStringMapOfStringObjectLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testHsetStringStringObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testHsetStringStringObjectLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testHdel() {
		fail("Not yet implemented");
	}

	@Test
	public void testHHasKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testHincr() {
		fail("Not yet implemented");
	}

	@Test
	public void testHdecr() {
		fail("Not yet implemented");
	}

	@Test
	public void testSGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testSHasKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testSSet() {
		fail("Not yet implemented");
	}

	@Test
	public void testSSetAndTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSGetSetSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testLGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testLGetListSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testLGetIndex() {
		fail("Not yet implemented");
	}

	@Test
	public void testLSetStringObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testLSetStringObjectLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testLSetStringListOfObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testLSetStringListOfObjectLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testLUpdateIndex() {
		fail("Not yet implemented");
	}

	@Test
	public void testLRemove() {
		fail("Not yet implemented");
	}

}
