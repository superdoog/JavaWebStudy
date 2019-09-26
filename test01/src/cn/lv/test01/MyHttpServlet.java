package cn.lv.test01;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		try {
			HttpServletRequest hreq = (HttpServletRequest)servletRequest;
			HttpServletResponse hresp = (HttpServletResponse)servletResponse;
			this.service(hreq,hresp);
		}catch (Exception e){
			e.printStackTrace();
		}


	}

	public void service(HttpServletRequest hreq, HttpServletResponse hresp) throws ServletException, IOException {
		String method = hreq.getMethod();
		if (method.equalsIgnoreCase("GET")){
			doGet(hreq, hresp);
		}else{
			doPost(hreq, hresp);
		}
	}

	protected void doGet(HttpServletRequest hreq, HttpServletResponse hresp) throws ServletException, IOException  {
	}
	protected void doPost(HttpServletRequest hreq, HttpServletResponse hresp) throws ServletException, IOException {
	}
}
