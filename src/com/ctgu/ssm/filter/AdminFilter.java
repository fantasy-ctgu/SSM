package com.ctgu.ssm.filter;

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

/**  
* @Title: AdminFilter.java  
*
* @Package com.ctgu.collegeservice.filter  
*
* @Description: 管理员权限过滤器
*
* @author Fantasy  
*
* @date 2018年12月22日  
*
* @version V1.0  
*/
public class AdminFilter implements Filter{

	@Override
	public void destroy() {
		//@Description: TODO
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		if(session.getAttribute("admin") == null && request.getRequestURL().indexOf("/admin/login") == -1) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//@Description: TODO
	}

}
