package org.zx.learn.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiang zeng on 2017/10/23.
 */
public class ZxCacheManager implements CacheManager {

    private static final Logger log = LoggerFactory.getLogger(CacheManager.class);

    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return null;
    }
}
