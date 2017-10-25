package org.zx.learn.shiro.filter;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zx.learn.redis.RedisDAO;

/**
 * Created by xiang zeng on 2017/10/24.
 *
 * @author xiang zeng
 */
public class SessionLogoutFilter extends LogoutFilter{
    @Resource
    private RedisDAO redisDAO;

    private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String sessionId = httpServletRequest.getSession().getId();
        redisDAO.delete(sessionId);
        return super.preHandle(request, response);

    }
}
