package com.liqiang.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.liqiang.common.sequence.Sequence;
import com.liqiang.common.sequence.zk.ZkDistributedSequence;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToolsApplicationTests {
	@Resource(name = "mysqlSequence")
	Sequence sequence;

	@Test
	public void testSequence() {
		final Map<String, String> map = new HashMap<String, String>();
		ExecutorService cachedThreadPool = Executors.newFixedThreadPool(50);
		for (int i = 0; i < 10000; i++) {
			cachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					long total = sequence.nextval("");
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
	public void testZkSequence() {
		Sequence sequence = new ZkDistributedSequence("127.0.0.1:2181");
		final Map<String, String> map = new HashMap<String, String>();
		ExecutorService cachedThreadPool = Executors.newFixedThreadPool(50);
		for (int i = 0; i < 10000; i++) {
			cachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					long total = sequence.nextval("sequenceName");
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
}
