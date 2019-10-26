package cn.lv.test;

import cn.lv.jdbc.MyDBUtils;
import cn.lv.model.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.DatabaseMetaData;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtilsTest {
	@Test
	public void dbutest1(){
		//获取到DBUtils中到关键类QueryRunner的对象
		QueryRunner qr = new QueryRunner();
		DataSource dataSource = null;
		Connection conn = null;

		try {
			dataSource = new ComboPooledDataSource("mysql");
			conn = dataSource.getConnection();
			String sql = "INSERT INTO users(`username`,`password`,`phone_no`,`address`,`reg_date`)values(?,?,?,?,?)";
			qr.update(conn,sql,"xiaobai","12345","12345","zhu","2020-1-2");


		}catch (Exception e){
			e.printStackTrace();
		}finally {
			MyDBUtils.close(conn,null,null);
		}
	}

	@Test
	public void dbuTest2(){
		QueryRunner qr = new QueryRunner();
		DataSource dataSource ;
		Connection conn = null;
		try {
			dataSource = new ComboPooledDataSource("mysql");
			conn = dataSource.getConnection();
			String sql = "select `id`,`username`,`password`,`phone_no`,`address`,`reg_date` from users;";
			List<User> list = qr.query(conn,sql,new rsHandler<List<User>>());
			System.out.println(list);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			MyDBUtils.close(conn,null,null);
		}


	}
	class rsHandler<T> implements ResultSetHandler<T>{

		@Override
		public T handle(ResultSet resultSet) throws SQLException {
			List<User> list = new ArrayList<>();
			User u = null;
			while (resultSet.next()){
				u = new User();
				u.setId(resultSet.getInt("id"));
				u.setUserName(resultSet.getString("username"));
				u.setPassword(resultSet.getString("password"));
				u.setPhoneNo(resultSet.getString("phone_no"));
				u.setAddress(resultSet.getString("address"));
				u.setRegDate(resultSet.getDate("reg_date"));
				list.add(u);
			}
			return (T) list;
		}
	}

	@Test
	public void dbuTest3(){
		QueryRunner qr = new QueryRunner();
		DataSource dataSource;
		Connection conn = null;
		try {
			dataSource = new ComboPooledDataSource("mysql");
			conn = dataSource.getConnection();
			String sql = "select `id` id,`username` username,`password` password,`phone_no` phoneNo,`address` address,`reg_date` regDate from users;";
			List<User> list = qr.query(conn,sql,new BeanListHandler<>(User.class));
			System.out.println(list);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			MyDBUtils.close(conn,null,null);
		}
	}

}
