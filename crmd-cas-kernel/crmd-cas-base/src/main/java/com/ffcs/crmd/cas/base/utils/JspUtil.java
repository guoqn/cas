package com.ffcs.crmd.cas.base.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * JSP 常量
 * 
 * @author LAIYONGMIN
 *
 */
public class JspUtil {

	/**
	 * 项目名
	 * 
	 * @param request
	 * @return
	 */
	public static String path(HttpServletRequest request) {
		return request.getContextPath();
	}

	/**
	 * 项目地址
	 * 
	 * @param request
	 * @return
	 */
	public static String contextPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ JspUtil.path(request);
	}

	/**
	 * 版本
	 * 
	 * @return
	 */
	public static String version() {
		return "1";
	}

	/**
	 * 获取本机IP .
	 *
	 * @return
	 */
	public static String getHostIp() {
		try {
			final String hostName = InetAddress.getLocalHost().getHostName();
			final InetAddress byName = InetAddress.getByName(hostName);
			return hostName + "(" + byName.getHostAddress() + ")";
		} catch (final UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

}
