package cn.brainysoon.repdata.shiro;

import cn.brainysoon.repdata.entity.UserEntity;
import cn.brainysoon.repdata.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by brainy on 17-7-4.
 */
public class CustomRealm extends AuthorizingRealm implements Authorizer {

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //得到用户名
        String name = (String) authenticationToken.getPrincipal();

        //找到该用户
        UserEntity userEntity = userService.getUserByName(name);

        //判断空
        if (userEntity == null) {

            throw new UnknownAccountException();
        }

        //是否杯激活
        if (userEntity.getSlead() < 0) {

            throw new LockedAccountException();
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        return new SimpleAuthenticationInfo(
                userEntity.getName(),
                userEntity.getPassword(),
                ByteSource.Util.bytes(userEntity.getId() + userEntity.getSlat()),
                getName()
        );
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }
}
