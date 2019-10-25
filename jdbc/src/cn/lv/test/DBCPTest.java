package cn.lv.test;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {

	/**
	 *  dbcp数据库连接池测试
	 */
	@Test
	public void dbcpTest() throws SQLException {
		//创建DataSource的实现类，dbcp包里实现这个接口的实现类BasicDataSource
		BasicDataSource dataSource = new BasicDataSource();

		//给数据库连接池dbcp提供连接数据库的必须的基本信息
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jdbc_01");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		//设置可选的数据库连接池的属性,这些属性就是对数据库连接进行管理的具体数值
		//数据库连接池中初始化的连接数
		dataSource.setInitialSize(10);
		//同一时刻可以向数据库申请的最大的连接数
		dataSource.setMaxTotal(50);
		//数据库连接池中保存的最少的空闲连接数
		dataSource.setMinIdle(10);
		//等待数据库连接池分配的最长时间，毫秒，超时抛出异常
		dataSource.setMaxWaitMillis(1000*5);

		//获取数据库的连接对象
		Connection conn = dataSource.getConnection();
		System.out.println(conn);

	}

	/**
	 * dbcp数据库连接池的配置信息和代码分离的用法
	 * BasicDataSourceFactory类
	 */
	@Test
	public void dpcpFactoryTest() throws Exception {
		Properties prop = new Properties();
		InputStream in = DBCPTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);

		//获取BasicDataSourceFactory类的对象不需要new
		DataSource dataSource = BasicDataSourceFactory.createDataSource(prop);
		//注意！传进去的配置文件中，键值对中"键名"一定要和dbcp包中DataSource接口的实现类中的属性名一致

		//通过连接池，获取连接对象
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}

}
