package cn.lv.mvcproject.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * jdbc工具类
 *
 */
public class jdbcUtils {

	//数据库连接池，C3P0
	private static DataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource("mysql");
	}
	/**
	 * 获取到数据库mysql到数据连接对象conn
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
