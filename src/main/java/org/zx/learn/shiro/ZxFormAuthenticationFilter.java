package org.zx.learn.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiang zeng on 2017/10/22.
 */
public class ZxFormAuthenticationFilter extends FormAuthenticationFilter{
    private static final Logger log = LoggerFactory.getLogger(ZxFormAuthenticationFilter.class);
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.debug("Request Path:{}", httpServletRequest.getRequestURL());
        return super.preHandle(request, response);
    }

    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response)
        throws Exception {
        request.getRequestDispatcher(getSuccessUrl()).forward(request, response);
    }
}
