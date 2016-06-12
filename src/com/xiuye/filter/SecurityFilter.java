package com.xiuye.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiuye.logger.Logger;
import com.xiuye.orm.User;

public class SecurityFilter implements Filter {

	private static boolean filter = false;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		
		Logger.CLOSEINFO = true;
		String filterStr = filterConfig.getInitParameter("filter");

		if ("true".equals(filterStr.toLowerCase().trim())) {
			this.filter = true;
		} else {
			this.filter = false;
		}

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		String uri = req.getRequestURI();// '/E-Book/'
		String url = req.getRequestURL().toString();// 'http://www.opensourcebookstore.com:8080/E-Book/'
		//System.out.println("uri:" + uri);
		//System.out.println("url:" + url);

		try {
			if (user == null) {
				if (uri.indexOf("pages") != -1) {
					if (!uri.contains("login") && !uri.contains("register")) {
						req.getRequestDispatcher("/notallowed.jsf").forward(
								req, res);
					}
				}

			} else {
				if (!user.isAdmin()) {
					if (uri.contains("manager")) {
						req.getRequestDispatcher("/notallowed.jsf").forward(
								req, res);
					}
				}
			}

			chain.doFilter(request, response);
		} catch (Exception e) {// 解决不需要或不关紧要的异常关闭，让异常不出现 这个异常无论怎样都捕获不了

		}
	}

	@Override
	public void destroy() {

	}

}
