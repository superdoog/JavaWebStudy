package cn.lv.mvcproject.controller;

import cn.lv.mvcproject.model.User;
import cn.lv.mvcproject.service.FactoryService;
import cn.lv.mvcproject.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author lv
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = FactoryService.getUserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符集
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String mn = req.getServletPath();
		mn = mn.substring(1,mn.length()-4);
		System.out.println(mn);
		try {
			Method method = this.getClass().getDeclaredMethod(mn, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

	}

	/**
	 * 实现首页的模糊查询
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = req.getParameter("username");
		String address = req.getParameter("address");
		String phoneNo = req.getParameter("phoneNo");

		username = username.replaceAll("`~!@#$%^&*()+=|\\{\\}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|\\{\\}【】‘；：”“’。，、？]","");
		address = address.replaceAll("`~!@#$%^&*()+=|\\{\\}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|\\{\\}【】‘；：”“’。，、？]","");
		phoneNo = phoneNo.replaceAll("`~!@#$%^&*()+=|\\{\\}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|\\{\\}【】‘；：”“’。，、？]","");

		List<User> list = userService.query(username,address,phoneNo);
		System.out.println(list);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

	}
}
