package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UsersInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Object aname = session.getAttribute("userid");
		if (aname == null) {
			return "usererror";// 没登录就跳到action
		}
		return arg0.invoke();// 唤醒执行下一个拦截器，如果不存在就执行action
	}
}
