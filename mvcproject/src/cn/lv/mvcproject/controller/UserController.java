package cn.lv.mvcproject.controller;

import cn.lv.mvcproject.model.User;
import cn.lv.mvcproject.service.FactoryService;
import cn.lv.mvcproject.service.UserService;
import cn.lv.mvcproject.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * @author lv
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = FactoryService.getUserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符集
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String mn = req.getServletPath();
		mn = mn.substring(1, mn.length() - 4);
		try {
			Method method = this.getClass().getDeclaredMethod(mn, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		User user = new User();
		user.setUsername(req.getParameter("username"));
		String name = user.getUsername();
		long rows = userService.getCountByName(name);
		if (rows > 0) {
			req.setAttribute("note", name + ",该名字已被占用，请换一个名字！");
			req.getRequestDispatcher("/add.jsp").forward(req, resp);
			return;
		}


		user.setPasword(req.getParameter("pasword"));
		user.setAddress(req.getParameter("address"));
		user.setPhoneNo(req.getParameter("phoneNo"));
		user.setRegDate(new Date());

		int row = userService.save(user);
		if (row > 0) {
			resp.sendRedirect(req.getContextPath() + "/main.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}

	}

	/**
	 * 实现首页的模糊查询
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String address = req.getParameter("address");
		String phoneNo = req.getParameter("phoneNo");

		username = username.replaceAll("`~!@#$%^&*()+=|\\{\\}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|\\{\\}【】‘；：”“’。，、？]", "");
		address = address.replaceAll("`~!@#$%^&*()+=|\\{\\}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|\\{\\}【】‘；：”“’。，、？]", "");
		phoneNo = phoneNo.replaceAll("`~!@#$%^&*()+=|\\{\\}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|\\{\\}【】‘；：”“’。，、？]", "");

		List<User> list = userService.query(username, address, phoneNo);
		//把结果集放到了req的属性空间
		System.out.println(list);
		req.setAttribute("userList", list);
		//把整个req,resp注入到jsp页面
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int rows = userService.deleteUserById(id);
		if (rows > 0) {
			resp.sendRedirect(req.getContextPath() + "/main.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userService.get(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
	}

	private void updatedo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User yUser = userService.get(id);

		String yUsername = yUser.getUsername();
		String xUsername = req.getParameter("username");

		long count = userService.getCountByName(xUsername);

		if (!yUsername.equals(xUsername) && count > 0) {
			req.setAttribute("note", xUsername + ",该名字已被占用，请换一个名字！");
			req.getRequestDispatcher("/update.udo?id=" + id).forward(req, resp);
			return;
		}

		yUser.setUsername(xUsername);
		yUser.setPasword(req.getParameter("pasword"));
		yUser.setAddress(req.getParameter("address"));
		yUser.setPhoneNo(req.getParameter("phoneNo"));

		int rows = userService.updateUserById(yUser);
		if (rows > 0) {
			resp.sendRedirect(req.getContextPath() + "/main.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}
	}

	/**
	 * 用户登陆
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pasword = req.getParameter("pasword");
		String expiredays = req.getParameter("expiredays");

		Cookie[] cookies = req.getCookies();

		//是否登陆标记，true已经登陆，false未登陆
		boolean login = false;
		//登陆账号
		String account = null;
		//通过cookie拿到的是否成功登陆到标记
		String ssid = null;

		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userKey")) {
					account = cookie.getValue();
				}
				if (cookie.getName().equals("ssid")) {
					ssid = cookie.getValue();
				}
			}
		}

		if (account != null && ssid != null) {
			login = ssid.equals(CookieUtil.md5Encrypt(username));
		}

		//login:false 取反 true : 用户还没登陆
		if (!login) {
			//用户第一次访问,通过访问数据库判断
			//登陆失败user为null
			User user = userService.login(username, pasword);
			if (user != null) {
				expiredays = expiredays == null ? "" : expiredays;
				switch (expiredays) {
					case "7":
						//cookie失效7天
						CookieUtil.createCookie(username, req, resp, 7*24*60*60);
						break;

					case "30":
						//cookie失效30天
						CookieUtil.createCookie(username, req, resp, 30*24*60*60);
						break;

					case "100":
						//cookie不失效，Integer.Max
						CookieUtil.createCookie(username, req, resp, Integer.MAX_VALUE);
						break;

					default:
						//cookie=-1，关闭浏览器失效
						CookieUtil.createCookie(username, req, resp, -1);
						break;
				}

				//登陆成功，跳转main.jsp
				req.getRequestDispatcher("main.jsp").forward(req, resp);
			} else {
				req.setAttribute("note", "用户名或密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else {
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		}
	}
}
