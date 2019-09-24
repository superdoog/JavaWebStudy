package cn.lv.test01;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class Servlet1 implements Servlet {
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
//		System.out.println(req.getParameter("username"));
//		System.out.println(req.getParameter("password"));
//
//		Map<String, String[]> map = req.getParameterMap();
//
//		Enumeration<String> enumeration = req.getParameterNames();
//		String[] ah = req.getParameterValues("aihao");
//		for(int i=0;i<ah.length;i++){
//			System.out.println(ah[i]);
//		}
		String username = req.getParameter("username");
		String psd = req.getParameter("password");
		if (username.equals("admin")&psd.equals("123456")){
			resp.getWriter().println("username and password is right");
		}else {
			resp.getWriter().println("username or password is wrong");
		}
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}
}
