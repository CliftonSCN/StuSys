package com.clifton.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.clifton.pojo.User;
import com.clifton.service.UserService;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author Clifton
 * @date 2019年8月9日 下午8:16:09
 * @project stusys
 */
public class MyRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	/**
	 * 用于的权限的授予。
	 * 
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String username = principalCollection.getPrimaryPrincipal().toString();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> roleName = userService.findRoles(username);
		Set<String> permissions = userService.findPermissions(username);
		info.setRoles(roleName);
		info.setStringPermissions(permissions);
		return info;
	}

	/**
	 * 首先执行这个登录验证
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取用户账号
		String username = token.getPrincipal().toString();
		User user = userService.findUserByUsername(username);
		if (user != null) {
			//将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数随便放一个就行了。
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),
					user.getUserPassword(), "a");
			return authenticationInfo;
		} else {
			return null;
		}
	}
}
