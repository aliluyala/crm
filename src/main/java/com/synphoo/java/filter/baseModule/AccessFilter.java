
package com.synphoo.java.filter.baseModule;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 资源访问过滤器1
 * @author mingfeng.wang
 *
 */
public class AccessFilter implements Filter{
	
	/**
	 * 1、初始化
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
	
	/**
	 * 2、过滤主方法
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		
		
	}
	
	/**
	 * 3、销毁
	 */
	@Override
	public void destroy() {
		
		
	}
	
}