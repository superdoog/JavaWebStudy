package cn.lv.test;

import cn.lv.jdbc.DBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class BatchTestTest {

	/**
	 * 测试statement插入数据
	 */
	@Test
	public void insertStatement() {
		Connection conn =  null;
		Statement stat = null;
		String sql = null;
		try {
			//获取连接
			conn = DBUtils.getConnection();
			//获取statement对象
			stat = conn.createStatement();
			//开启事物
			//DBUtils.startTransaction(conn);
			long start = System.currentTimeMillis();
			//写sql 运行
			for (int i=0;i<100000;i++){
				sql = "insert into `student`(`name`,`age_id`)values('name"+i+"','"+i+"');";
				stat.executeUpdate(sql);

			}
			long end = System.currentTimeMillis();
			//提交事物
			//DBUtils.commitTransaction(conn);
			System.out.println("statement插入数据耗时："+(end-start)+"ms");

		}catch (Exception e){
			e.printStackTrace();
			//出现异常 回滚事物
			//DBUtils.rollbackTransaction(conn);
		}finally {
			DBUtils.close(conn,stat,null);
		}
	}

	/**
	 * 测试preparedStatementTest插入数据
	 */
	@Test
	public void preparedStatementTest(){
		Connection conn =  null;
		PreparedStatement ps = null;
		String sql = null;
		try {
			//获取连接
			conn = DBUtils.getConnection();

			//开启事物
			DBUtils.startTransaction(conn);
			long start = System.currentTimeMillis();
			//写sql 运行
			for (int i=0;i<100000;i++){
				sql = "insert into `student`(`name`,`age_id`)values(?,?);";
				ps = conn.prepareStatement(sql);
				ps.setObject(1,"name"+i);
				ps.setObject(2, i);
				ps.executeUpdate();
			}
			long end = System.currentTimeMillis();
			//提交事物
			DBUtils.commitTransaction(conn);
			System.out.println("PreparedStatement插入数据耗时："+(end-start)+"ms");

		}catch (Exception e){
			e.printStackTrace();
			//出现异常 回滚事物
			DBUtils.rollbackTransaction(conn);
		}finally {
			DBUtils.close(conn,ps,null);
		}
	}

	/**
	 * Batch插入数据
	 */
	@Test
	public void batchTest(){
		Connection conn =  null;
		PreparedStatement ps = null;
		String sql = null;
		try {
			//获取连接
			conn = DBUtils.getConnection();

			//开启事物
			DBUtils.startTransaction(conn);
			long start = System.currentTimeMillis();
			//写sql 运行
			sql = "insert into `student`(`name`,`age_id`)values(?,?);";
			ps = conn.prepareStatement(sql);
			for (int i=0;i<100000;i++){
				ps.setString(1,"name"+i);
				ps.setInt(2, i);
				ps.addBatch();
				if (i%300==0) {
					//累计300条sql语句，执行批量处理一次
					ps.executeBatch();
					//把已经执行的sql语句从ps的缓存中清除
					ps.clearBatch();
				}
			}
			if (100000%300!=0){//sql总条数不是批量的整数倍时还需再处理一次
				//最后执行一次
				ps.executeBatch();
				//清除最后积累的sql语句
				ps.clearBatch();
			}
			long end = System.currentTimeMillis();
			//提交事物
			DBUtils.commitTransaction(conn);
			System.out.println("PreparedStatement batch 插入数据耗时："+(end-start)+"ms");

		}catch (Exception e){
			e.printStackTrace();
			//出现异常 回滚事物
			DBUtils.rollbackTransaction(conn);
		}finally {
			DBUtils.close(conn,ps,null);
		}
	}
}