package cn.lv.test01;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String user = hreq.getParameter("username");
//		String psd = hreq.getParameter("password");
//
//		if (user.equals(getServletConfig().getServletContext().getInitParameter("user"))
//				&& psd.equals(getServletConfig().getServletContext().getInitParameter("password"))){
//			hresp.getWriter().println("LOGIN SUCCESS");
//		}else {
//			hresp.getWriter().println("LOGIN FAILED");
//		}

		//pageContext,在servlet里不可用

		//request
		response.getWriter().println(request.getAttribute("request"));

		//session
		response.getWriter().println(request.getSession().getAttribute("session"));

		//application
		response.getWriter().println(getServletContext().getAttribute("application"));

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
