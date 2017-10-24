package org.zx.learn.shiro;

import java.io.Serializable;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zx.learn.redis.RedisDAO;

/**
 * Created by xiang zeng on 2017/10/18.
 * @author zx
 */
public class ZxSessionManager extends EnterpriseCacheSessionDAO {
    private static final Logger log = LoggerFactory.getLogger(ZxCacheManager.class);

    @Autowired
    private RedisDAO redisDAO;

    private Long expire;
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected void doUpdate(Session session) {
        log.debug("update session,sessionid:{}",session.getId());
        saveSession(session);
    }

    @Override
    protected void doDelete(Session session) {
        if (session == null || session.getId() == null){
            log.error("session or sessionid is null");
        }
        redisDAO.delete(RedisDAO.REDIS_SESSION_PRE+session.getId());
        super.doDelete(session);
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = super.doReadSession(sessionId);
        if (session == null ) {
            session = redisDAO.getObject(RedisDAO.REDIS_SESSION_PRE+sessionId);
        }
        return session;
    }
    private void saveSession(Session session){
        if (session == null){
            log.debug("session is null");
        }
        redisDAO.setObject(RedisDAO.REDIS_SESSION_PRE+session.getId(), session,expire/1000);
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }
}
