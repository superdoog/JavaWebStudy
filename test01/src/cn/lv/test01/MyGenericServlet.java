package cn.lv.test01;

import javax.servlet.*;
import java.io.IOException;

public abstract class MyGenericServlet implements Servlet {

	private ServletConfig config;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		this.config = servletConfig;
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}
}
