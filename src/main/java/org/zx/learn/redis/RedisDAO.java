package org.zx.learn.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;
import org.springframework.util.SerializationUtils;

/**
 * Created by xiang zeng on 2017/10/22.
 */
public class RedisDAO extends RedisTemplate {

    private static  final  Logger log = LoggerFactory.getLogger(RedisDAO.class);

    public static final String REDIS_SESSION_PRE = "JSESSIONID:";
    public void setObject(Object key, Object value,Long timeout){

        if(timeout == null){
            opsForValue().set(key,SerializationUtils.serialize(value));
        }else{
            opsForValue().set(key,SerializationUtils.serialize(value),timeout, TimeUnit.SECONDS);
        }

    }
    public <T> T getObject(Object key) {
        byte[] bytes = (byte[]) opsForValue().get(key);
        return (T)SerializationUtils.deserialize(bytes);
    }

}
