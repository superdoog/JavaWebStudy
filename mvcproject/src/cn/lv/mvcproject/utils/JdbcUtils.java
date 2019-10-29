package cn.lv.mvcproject.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * jdbc工具类
 *
 * @author lvsihao
 */
public class JdbcUtils {

	/**数据库连接池，C3P0**/
	private static DataSource dataSource;
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

	/**
	 * 关闭数据库连接对象的方法
	 * @param conn
	 */
	public static void closeConn(Connection conn){
		if(null != conn){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollbackTransaction(Connection conn){
		if (null != conn){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


}
