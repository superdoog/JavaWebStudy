package test;

import cn.lv.mvcproject.dao.BaseDao;
import cn.lv.mvcproject.dao.UserDaoImpl;
import cn.lv.mvcproject.model.User;
import cn.lv.mvcproject.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author lvsihao
 */
public class test {
	@Test
	public void t(){
		UserDaoImpl udi = new UserDaoImpl();
		BaseDao bd = new BaseDao();
		User user = new User();
		user.setUsername("TESTusername");
		user.setPasword("TESTpasword");
		user.setAddress("TESTaddress");
		user.setPhoneNo("TESTphoneNo");
		user.setRegDate(new Date());

		System.out.println(user);

		String sql = "insert into `users`(`username`,`pasword`,`phone_no`,`address`,`reg_date`)value(?,?,?,?,?)";
//
//		try {
//			Connection conn = JdbcUtils.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setObject(1,user.getUsername());
//			ps.setObject(2,user.getPasword());
//			ps.setObject(3,user.getAddress());
//			ps.setObject(4,user.getPhoneNo());
//			ps.setObject(5,user.getRegDate());
//			ps.execute();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		//udi.save(user);
		System.out.println(bd.update(sql,user.getUsername(), user.getPasword(), user.getAddress(), user.getPhoneNo(), user.getRegDate()));
	}

	@Test
	public void d(){
		Date date = new Date();
		System.out.println(date);
	}
}
