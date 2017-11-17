package com.test.Util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *  ehcache 工具类
 */
public class EhcacheUtil {
    //ehcache.xml 保存在src/main/resources/
    private static final String path = "/ehcache.xml";

    private URL url;

    private CacheManager manager;

    private static EhcacheUtil ehCache;

    private EhcacheUtil(String path) {
        url = getClass().getResource(path);
        manager = CacheManager.create(url);
    }

    public static EhcacheUtil getInstance() {
        if (ehCache == null) {
            ehCache = new EhcacheUtil(path);
        }
        return ehCache;
    }

    public void put(String cacheName, Integer key, Object value) {
        Cache cache = manager.getCache(cacheName);
        Element element = null;
        Map<String,Object> map = new HashMap<String,Object>();

        if(key==1){
            map.put("BankName",((Map)value).get("BankName"));
            element = new Element(key,map );
        }else{
            map.put("xinshou",((Map)value).get("xinshou"));
            element = new Element(key,map );
        }
        cache.put(element);
    }

    public Map get(String cacheName, Integer key) {
        System.out.println("111");
        Cache cache = manager.getCache(cacheName);
        Element element = cache.get(key);
        return element == null ? null : (Map)element.getObjectValue();
    }

    public Cache get(String cacheName) {
        return manager.getCache(cacheName);
    }

    public void remove(String cacheName, String key) {
        Cache cache = manager.getCache(cacheName);
        cache.remove(key);
    }
}