package cn.lv.mvcproject.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;

public class CookieUtil {
	private static final String KEY = ";cookie@lv.com";

	/**
	 * 命令浏览器创建Cookie文件用的方法
	 *
	 * @param username cookie 用户名
	 * @param req
	 * @param resp     调用addCoolie方法的response对象
	 * @param sec      调用cookie失效的时间，单位秒
	 */
	public static void createCookie(String username, HttpServletRequest req, HttpServletResponse resp, int sec) {

		Cookie usercookie = new Cookie("userKey", username);
		Cookie ssidcookie = new Cookie("ssid", md5Encrypt(username));
		usercookie.setMaxAge(sec);
		ssidcookie.setMaxAge(sec);

		resp.addCookie(usercookie);
		resp.addCookie(ssidcookie);

	}

	/**
	 * 加密方法
	 *
	 * @param ss 明文
	 * @return
	 */
	public static String md5Encrypt(String ss) {
		ss = ss == null ? "" : ss + KEY;
		//加密字典
		char[] md5Digist = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			//放入数据
			md.update(ss.getBytes());
			//加密
			byte[] mssarr = md.digest();

			int len = mssarr.length;
			char[] str = new char[len*2];
			//计数
			int k=0;

			for (int i=0;i<len;i++){
				byte b = mssarr[i];
				str[k++] = md5Digist[b >>> 4 & 0xf];
				str[k++] = md5Digist[b & 0xf];
			}
			return new String(str);
		}catch (Exception e){
			e.printStackTrace();
		}

		return null;
	}
}
