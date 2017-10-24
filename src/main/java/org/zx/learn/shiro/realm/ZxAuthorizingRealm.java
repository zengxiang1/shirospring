package org.zx.learn.shiro.realm;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.security.auth.login.AccountNotFoundException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.zx.learn.dao.SysUserMapper;
import org.zx.learn.model.SysUser;

/**
 * Created by xiang zeng on 2017/10/19.
 */
public class ZxAuthorizingRealm extends AuthorizingRealm {

    @Resource
    private SysUserMapper sysUserMapper;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<String> permissions = new ArrayList<String>();
        permissions.add("user:create");
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
        throws AuthenticationException {
        SysUser sysUser = sysUserMapper.selectByUserName((String) token.getPrincipal());
        if (sysUser == null) {
            throw  new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(sysUser,  sysUser.getPasswd(),null,getName());
    }
}
