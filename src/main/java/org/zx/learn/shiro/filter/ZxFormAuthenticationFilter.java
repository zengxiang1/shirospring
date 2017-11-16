package org.zx.learn.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zx.learn.exception.ServiceException;
import org.zx.learn.utils.JsonParamUtils;

import java.io.IOException;

/**
 * Created by xiang zeng on 2017/10/22.
 */
public class ZxFormAuthenticationFilter extends FormAuthenticationFilter{
    private static final Logger log = LoggerFactory.getLogger(ZxFormAuthenticationFilter.class);
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info("Request Path:{}", httpServletRequest.getRequestURL());
        return super.preHandle(request, response);
    }

    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response)
        throws Exception {
        request.getRequestDispatcher(getSuccessUrl()).forward(request, response);
    }


    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        try {
            String jsonParam = JsonParamUtils.getRequestJsonString((HttpServletRequest)request);
            JsonObject paramObject = new JsonParser().parse(jsonParam).getAsJsonObject();
            if (paramObject.has(getUsernameParam())) {
                return super.createToken(paramObject.get(getUsernameParam()).getAsString(),paramObject.get(getPasswordParam()).getAsString(),request,response);
            }
            else {
                return super.createToken(getUsername(request), getPassword(request), request, response);
            }

        } catch (IOException e) {
            throw new ServiceException(8,"认证信息获取失败");
        }
    }
}
