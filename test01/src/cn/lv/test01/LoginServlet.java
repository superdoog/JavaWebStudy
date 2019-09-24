package cn.lv.test01;

import javax.servlet.*;
import java.io.IOException;

public class LoginServlet implements Servlet {
	private String name;
	private String psd;
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		name = servletConfig.getInitParameter("user");
		psd = servletConfig.getInitParameter("password");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		String loginName = servletRequest.getParameter("username");
		String loginPassword = servletRequest.getParameter("password");

		if (loginName.equals(name)&loginPassword.equals(psd)){
			servletResponse.getWriter().println("LOGIN SUCCESS");
		}else {
			servletResponse.getWriter().println("LOGIN FIELD");
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
