package cn.lv.mywebproject;

import javax.servlet.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MyFirstServlet implements Servlet {

	private ServletContext servletContext;
	public MyFirstServlet(){

		System.out.println("MyFirstServlet");
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletContext = servletConfig.getServletContext();
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		//HttpServletResponse res = (HttpServletResponse)servletResponse;
		//实现了向servletContext域对象对属性空间里存入了一个键值对
//		servletContext.setAttribute("aaaa", "1111");
//		servletResponse.getWriter().println(servletContext.getInitParameter("zzz"));
		Properties properties = new Properties();
		String popFileRealPath = servletContext.getRealPath("aaa.properties");
		properties.load(new FileReader(popFileRealPath));
		System.out.println(properties.getProperty("user"));
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}
}
