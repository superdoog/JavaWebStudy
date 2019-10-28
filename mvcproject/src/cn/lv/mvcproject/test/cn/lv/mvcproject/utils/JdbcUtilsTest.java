package cn.lv.mvcproject.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;


class JdbcUtilsTest {

	@Test
	void getConnection() {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}
}