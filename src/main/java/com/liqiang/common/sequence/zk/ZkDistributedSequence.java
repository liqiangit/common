package com.liqiang.common.sequence.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.LoggerFactory;

import com.liqiang.common.sequence.Sequence;

public class ZkDistributedSequence implements Sequence{
	 private static final org.slf4j.Logger log = LoggerFactory.getLogger(ZkDistributedSequence.class);

	    private CuratorFramework client;
	     /**
	     * Curator RetryPolicy maxRetries
	     */
	    private int maxRetries=3;
	    /**
	     * Curator RetryPolicy baseSleepTimeMs
	     */
	    private final int baseSleepTimeMs=1000;

	    public ZkDistributedSequence(String zookeeperAddress){
	        try{
	            RetryPolicy retryPolicy = new ExponentialBackoffRetry(baseSleepTimeMs, maxRetries);
	            client = CuratorFrameworkFactory.newClient(zookeeperAddress, retryPolicy);
	            client.start();
	        }catch (Exception e){
	            log.error(e.getMessage(),e);
	        }catch (Throwable ex){
	            ex.printStackTrace();
	            log.error(ex.getMessage(),ex);
	        }
	    }

	    public int getMaxRetries() {
	        return maxRetries;
	    }

	    public void setMaxRetries(int maxRetries) {
	        this.maxRetries = maxRetries;
	    }

	    public int getBaseSleepTimeMs() {
	        return baseSleepTimeMs;
	    }

		public Long nextval(String sequenceName) {
	        try {
	            int value=client.setData().withVersion(-1).forPath("/"+sequenceName,"".getBytes()).getVersion();
	            return new Long(value);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	}