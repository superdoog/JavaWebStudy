package cn.lv.mywebproject;

import javax.servlet.*;
import java.io.IOException;

public class MySecondServlet implements Servlet {

	private ServletContext servletContext;
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		servletContext = servletConfig.getServletContext();
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//		String value = (String)servletContext.getAttribute("aaaa");
//		System.out.println("在MySecondServlet里获取到第一个里放入到servletContext域对象的值--"+value);
//		servletResponse.getWriter().println(value);

		servletResponse.getWriter().println(servletContext.getInitParameter("zzz"));
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}
}
