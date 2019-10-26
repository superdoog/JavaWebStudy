package cn.lv.test;

import cn.lv.jdbc.MyDBUtils;

import java.sql.*;

public class DatabaseMataDataTest {
	public static void main(String[] args) throws Exception {
		Connection connection = MyDBUtils.getConnection();
		//获取数据库元数据对象
		DatabaseMetaData dmd = connection.getMetaData();
		System.out.println(dmd.getURL());
		System.out.println(dmd.getUserName());
		System.out.println(dmd.isReadOnly());
		System.out.println(dmd.getDatabaseProductName());
		System.out.println(dmd.getDatabaseProductVersion());
		System.out.println(dmd.getDriverName());
		System.out.println(dmd.getDriverVersion());

		String sql = "select id id,`username` userName,`password` password,`phone_no` phoneNo,`address` address,`reg_date` regDate from users where id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setObject(1, 6);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnName(4));
		System.out.println(rsmd.getColumnLabel(4));
		System.out.println(rsmd.getColumnTypeName(1));
		System.out.println(rsmd.getColumnDisplaySize(1));
		System.out.println(rsmd.isNullable(1));
		System.out.println(rsmd.isAutoIncrement(1));

		rs.close();
		connection.close();

	}

}
