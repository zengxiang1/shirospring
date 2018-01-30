package org.zx.learn.shiro.realm;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.zx.learn.dto.AuthDTO;
import org.zx.learn.dto.SysResourceDTO;
import org.zx.learn.service.UserService;

/**
 * Created by xiang zeng on 2017/10/19.
 */
public class ZxAuthorizingRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<String> permissions = new ArrayList<>();
        AuthDTO authDTO = (AuthDTO) SecurityUtils.getSubject().getPrincipal();
        List<SysResourceDTO> sysResourceDTOList = userService.listResourcePermissions(authDTO.getId());
        for (SysResourceDTO sysResourceDTO : sysResourceDTOList) {
            if (! "".equals(sysResourceDTO.getResourcePermission())){
                permissions.add(sysResourceDTO.getResourcePermission());
            }
        }
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
        throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        AuthDTO sysUser = userService.getAuthenticateInfo(userName);
        if (sysUser == null) {
            throw  new UnknownAccountException();
        }
        if (0 != sysUser.getAccountStatus()){
            throw new AccountException("账户异常");
        }
        return new SimpleAuthenticationInfo(sysUser,sysUser.getAccountPwd(),null,getName());
    }
}
