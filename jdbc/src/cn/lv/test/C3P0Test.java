package cn.lv.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Test {

	/**
	 * c3p0数据库连接池的用法测试
	 */
	@Test
	public void c3p0Test() throws PropertyVetoException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		//loads the jdbc driver
		cpds.setDriverClass( "com.mysql.jdbc.Driver" );
		cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/jdbc_01?useUnicode=true&characterEncoding=utf8" );
		cpds.setUser("root");
		cpds.setPassword("123456");

		Connection conn = cpds.getConnection();
		System.out.println(conn);
	}

	/**
	 * 用xml格式的配置文件分离配置信息测试连接
	 */
	@Test
	public void c3p0XmlTest() throws SQLException {
		DataSource dataSource = new ComboPooledDataSource("mysql");
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
