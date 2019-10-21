package cn.lv.jdbc;

import cn.lv.model.User;
import com.mysql.jdbc.Connection;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class DBUtils {
	/**
	 * 获取数据库连接的方法
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		Properties prop = new Properties();//创建Properties类的对象，获取jdbc.properties
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
	public static int IUD(String sql,Object... args){//Object... args 不确定个数不确定类型的参数列表

		Connection conn = null;
//		Statement statement = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);

			for (int i=0;i<args.length;i++){
				ps.setObject(i+1,args[i]);
			}

			count = ps.executeUpdate();//执行sql，返回结果，返回影响到到数据记录条数

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			close(conn,ps,null);
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

	/**
	 * 查询一条信息
	 * @param sql
	 * @param args
	 * @return
	 */
	public static User getOneUser(String sql,Object... args){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//写sql语句
			//String sql = "select id,username,`password`,phone_no,address,reg_date from users where id="+userid;
			//执行sql,获取statement对象
			ps = conn.prepareStatement(sql);
			for (int i=0;i<args.length;i++){
				ps.setObject(i+1, args[i]);
			}
			rs = ps.executeQuery();
			//从rs中拿出数据库取出的具体值
			if (rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPassword(rs.getString("phone_no"));
				user.setAddress(rs.getString("address"));
				user.setRegDate(rs.getDate("reg_date"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return user;
	}

	/**
	 * 查询一条数据的通用方法
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T getOneData(Class clazz, String sql, Object... args){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		T entity = null;

		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//获取PreparedStatement
			ps = conn.prepareStatement(sql);
			//替换ps中的?占位符
			for (int i=0;i<args.length;i++){
				ps.setObject(i+1 ,args[i]);
			}
			rs = ps.executeQuery();
			//取出rs中的值
			if (rs.next()){
				entity = (T)clazz.getDeclaredConstructor().newInstance();//通过反射获取到对象
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				Map<String, Object> map = new HashMap<>();

				//把结果集中的值取出来放入map
				for (int i=1;i<=columnCount;i++){
					String key = rsmd.getColumnLabel(i);
					Object val = rs.getObject(key);

					map.put(key, val);
				}
				//把取出的值封装到entity
				for (Map.Entry<String, Object> entry:map.entrySet()){
					Field field = clazz.getDeclaredField(entry.getKey());//字段名
					field.setAccessible(true);//忽略类型private修饰符
					field.set(entity, entry.getValue());//字段对应的数值
				}
			}


		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}

		return entity;
	}
}
