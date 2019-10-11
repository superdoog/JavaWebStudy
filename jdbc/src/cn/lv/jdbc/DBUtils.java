package cn.lv.jdbc;

import com.mysql.jdbc.Connection;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DBUtils {
	/**
	 * 获取数据库连接的方法
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		Properties prop = new Properties();//创建Propertie类的对象，获取jdbc.properties
		//取到配置文件的内容
		InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);//把拿到的配置文件的内容，放到Properties类的对象prop

		String driverClass = prop.getProperty("driverClass");//通过prop对象的getProperties方法拿到具体的值
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
//
//		//连接数据库，用到Driver接口实现类
//		Driver driver = (Driver) Class.forName(driverClass).getDeclaredConstructor().newInstance();
//		//用dirver类给我们提供的方法来实现连接数据库
//
//		Properties info = new Properties();
//		info.put("user", user);//属性类型参数info，必须包含两个键值对，user:数据库的账号
//		info.put("password", password);

		//第一步：加载数据库驱动，给DriverManager注册数据库驱动
		Class.forName(driverClass);//通过反射，加载数据库的驱动到DriverManager
//		Class.forName(这里可以同时注册多个数据库驱动)

		//第二步：通过DriverManager的getConnection方法获取数据库的连接
		Connection conn = (Connection) DriverManager.getConnection(url, user, password);
		return conn;
	}

	/**
	 * 通用增删改方法
	 * @param sql
	 * @return
	 */
	public static int IUD(String sql){

		Connection conn = null;
		Statement statement = null;
		int count = 0;
		try {
			conn = DBUtils.getConnection();
			statement = conn.createStatement();
			count = statement.executeUpdate(sql);//执行sql，返回结果，返回影响到到数据记录条数

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			close(conn,statement,null);
		}

		return count;
	}

	/**
	 * 通用用来关闭数据库连接有关的所有资源的关闭操作
	 */
	public static void close(java.sql.Connection conn, Statement statement, ResultSet rs){

		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}