package com.clifton.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clifton.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

/**  
* @author Clifton  
* @date 2019年8月14日 下午6:48:14 
* @project stusys
*/
public class AisellPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		logger.info("+================================="+request.toString());
		Subject subject = getSubject(request, response);
	    // If the subject isn't identified, redirect to login URL
	    if (subject.getPrincipal() == null) {
	        saveRequestAndRedirectToLogin(request, response);
	    } else {
	        //一.拿到请求头
	        HttpServletRequest req = (HttpServletRequest)request;
	        // 拿到响应头
	        HttpServletResponse resp = (HttpServletResponse)response;
	        //设置响应头
	        resp.setContentType("application/json;charset=UTF-8");
	        String xr = req.getHeader("X-Requested-With");
	        //二.判断这个请求头是否是Ajax请求
	        if(xr!=null && "XMLHttpRequest".equals(xr)){
	            //返回一个json {"success":false,"msg":"权限不足，请充值！"}
	        	response.setContentType("application/json; charset=utf-8");
	        	ObjectMapper objectMapper = new ObjectMapper();
	            response.getWriter().write(objectMapper.writeValueAsString(new Response().failure("没有权限")));
//	        	WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
	        }else {
	            //普通请求:拿到没有权限的跳转路径,进行跳转
	            String unauthorizedUrl = getUnauthorizedUrl();
	            if (StringUtils.hasText(unauthorizedUrl)) {
	                WebUtils.issueRedirect(request, response, unauthorizedUrl);
	            } else {
	                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
	            }
	        }
	    }
	    return false;

	}

}
