package cn.lv.mvcproject.dao;

import cn.lv.mvcproject.model.User;
import cn.lv.mvcproject.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoimplTest {
	UserDao userDao = new UserDaoimpl();

	@Test
	void get() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		User user = null;
		try {
			conn.setAutoCommit(false);
			user = userDao.get(conn,2);
			conn.commit();
		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			JdbcUtils.closeConn(conn);
		}

		System.out.println(user);
	}
}