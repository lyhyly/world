package com.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

@SuppressWarnings({ "serial" })
public class BaseAction extends ActionSupport
		implements RequestAware, SessionAware, ServletRequestAware, ServletResponseAware {

	protected static Logger logs = LoggerFactory.getLogger(BaseAction.class);
	public Map<String, Object> request;
	public Map<String, Object> session;
	public HttpServletRequest serRequest;
	public HttpServletResponse response;

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public void setServletRequest(HttpServletRequest serRequest) {
		this.serRequest = serRequest;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void log(String s) {
		logs.info(s);
	}

	public void writeResponse(String responseContent) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(responseContent);
		} catch (IOException e) {
			logs.info("" + e.getStackTrace());
		}
	}

}
