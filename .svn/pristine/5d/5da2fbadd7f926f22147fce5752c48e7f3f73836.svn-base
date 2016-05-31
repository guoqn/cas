package com.ffcs.crmd.cas.base.cache;

import com.ctg.itrdc.platform.common.utils.type.ArrayUtils;
import com.ffcs.crmd.cas.constants.PubConstant;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class LocalCache {
	
	private static LocalCache localCache = null;

	   private static final long duration = 3600;
	    private static final int initialCapacity = 100;
	    private static final int maximumSize = 100000;
	    private static final Cache<String,Object> cache
	            //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
	            = CacheBuilder.newBuilder()
	            //设置并发级别为8，并发级别是指可以同时写缓存的线程数
	            .concurrencyLevel(8)
	            //设置写缓存后3600秒钟过期
	            .expireAfterWrite(duration, TimeUnit.SECONDS)
	            //设置缓存容器的初始容量为100
	            .initialCapacity(initialCapacity)
	            //设置缓存最大容量为100000，超过100000之后就会按照LRU最近虽少使用算法来移除缓存项
	            .maximumSize(maximumSize)
	            //设置要统计缓存的命中率
	            .recordStats()
	            .build();
	protected LocalCache() {
		/* 保护 */
	}
	
	public static LocalCache getInstance() {
		if (localCache == null) {
			localCache = new LocalCache();
		}
		return localCache;
	}
		
	public boolean contains(String key){
		if(get(key) != null)
			return true;
		return false;
	}

	public void put(String key, Object obj){
		if (obj != null) {
			cache.put(key, obj);
		}
	}
	
	public Object get(String key){
		return cache.getIfPresent(key);
	}
	
	public void clean(){
		cache.invalidateAll();
	}
	
	public String getCacheStats(){
		return cache.stats().toString();
	}

	/**
	 * 获取所有的key值
	 * @author YULIYAO 2016/5/6
	 * return
	 */
	public List getAllKey() {
		Set set = cache.asMap().keySet();
		if (set != null) {
			return Arrays.asList(set.toArray());
		}
		return null;
	}

	/**
	 * 删除指定key
	 * @author YULIYAO 2016/5/6
	 * return 
	 */
	public Object remove(String key) {
		return cache.asMap().remove(key);
	}

	/**
	 * 生成key
	 * @author YULIYAO 2016/2/26
	 * return
	 */
	public static String genKey(String... keys) {
		StringBuffer stringBuffer = new StringBuffer();
		if (ArrayUtils.isNotEmpty(keys)) {
			for (int i = 0; i < keys.length; i++) {
				if (i < keys.length - 1) {
					stringBuffer.append(keys[i]).append(PubConstant.SPLIT_SEPERATOR.getValue());
				} else {
					stringBuffer.append(keys[i]);
				}
			}
		}
		return stringBuffer.toString();
	}

}
