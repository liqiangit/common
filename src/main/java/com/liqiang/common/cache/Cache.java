package com.liqiang.common.cache;

public interface Cache {
	/**
	 * 获取SYS_CACHE缓存
	 *
	 * @param key
	 * @return Object
	 */
	public Object getSysCache(String key);

	/**
	 * 写入SYS_CACHE缓存
	 *
	 * @param key timeToLiveSeconds 缓存时间
	 */
	public void putSysCache(String key, Object value, int timeToLiveSeconds);

	/**
	 * 写入SYS_CACHE缓存
	 *
	 * @param key
	 */
	public void putSysCache(String key, Object value);

	/**
	 * 从SYS_CACHE缓存中移除
	 *
	 * @param key
	 */
	public void removeSysCache(String key);

	// ========================================================================
	/**
	 * 获取缓存
	 *
	 * @param cacheName
	 * @param key
	 * @return Object
	 */
	public Object get(String cacheName, String key);

	/**
	 * 写入缓存
	 *
	 * @param cacheName
	 * @param key
	 * @param value
	 * @param timeToLiveSeconds 缓存时间（秒）
	 */
	public void put(String cacheName, String key, Object value, int timeToLiveSeconds);

	/**
	 * 写入缓存
	 *
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public void put(String cacheName, String key, Object value);

	/**
	 * 从缓存中移除
	 *
	 * @param cacheName
	 */
	public void remove(String cacheName, String key);
}
