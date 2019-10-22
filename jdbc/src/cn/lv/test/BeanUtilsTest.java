package cn.lv.test;

import cn.lv.model.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
		User user = new User();

		System.out.println(user);

		BeanUtils.setProperty(user,"userName","aabb");
		System.out.println(BeanUtils.getProperty(user, "userName"));
	}
}
