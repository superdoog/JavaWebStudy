package cn.lv.test;

import cn.lv.dao.BaseDao;
import cn.lv.jdbc.MyDBUtils;

import java.sql.Connection;

public class TransationTest {
	public static void main(String[] args) throws Exception {
		BaseDao baseDao = new BaseDao();
		// 同一个connection才能事务处理
		Connection conn = MyDBUtils.getConnection();
		 	try {

			//开始事物
			conn.setAutoCommit(false);

			String sql1 = "update `account` set `balance` =500 where `id`=1";
			baseDao.iud(conn, sql1);

//			int a = 10/0;
//			System.out.println(a);

			String sql2 = "update `account` set `balance` =1500 where `id`=2";
			baseDao.iud(conn, sql2);

			//提交事物
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			//回滚
			conn.rollback();
		}finally {
			MyDBUtils.close(conn,null,null);
		}

	}
}
