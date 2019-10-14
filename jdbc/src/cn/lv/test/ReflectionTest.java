package cn.lv.test;

import cn.lv.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;

public class ReflectionTest {
	public static void main(String[] args) throws Exception {
		User user = new User();

		Class c = user.getClass();
		Class c2 = User.class;
		Class c3 = Class.forName("cn.lv.model.User");

		User user2 = (User)c.getDeclaredConstructor().newInstance();

		Constructor ct = c.getConstructor(int.class,String.class,String.class,String.class,String.class, Date.class);
		Constructor ct1 = c.getConstructor();
		Constructor[] carray = c.getConstructors();

		for (int i=0;i<carray.length;i++){
			System.out.println(carray[i].getName());
		}

		System.out.println(c.getPackage());

		Method method = c.getMethod("getId");
		System.out.println(method);
	}
}
