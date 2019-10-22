package cn.lv.dao;

import cn.lv.jdbc.DBUtils;
import com.mysql.jdbc.Connection;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BaseDao {

	/**
	 * 替换sql语句里？占位符的代码
	 * @return
	 */
	private PreparedStatement insteadHolder(PreparedStatement ps,Object...args) throws SQLException {
		for (int i=0;i<args.length;i++){
			ps.setObject(i+1,args[i]);
		}
		return ps;
	}


	private <T> T getEntity(ResultSet rs, Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
		T entity = (T) clazz.getDeclaredConstructor().newInstance();//通过反射获取到对象
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		//把结果集中的值取出来放入
		for (int i = 1; i <= columnCount; i++) {
			String key = rsmd.getColumnLabel(i);
			Object val = rs.getObject(key);
			//把取出的值封装到entity
//					Field field = clazz.getDeclaredField(key);//字段名
//					field.setAccessible(true);//忽略类型private修饰符
//					field.set(entity, val);//字段对应的数值
			BeanUtils.setProperty(entity, key, val);//不破坏类的规则
		}
		return entity;
	}

	//实现数据库表记录到增删改操作到iud方法
	/**
	 * 通用增删改方法
	 * @param sql
	 * @return
	 */
	public int iud(String sql,Object... args){
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			//替换ps中的?占位符
			insteadHolder(ps, args);
			count = ps.executeUpdate();//执行sql，返回结果，返回影响到到数据记录条数
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.close(conn,ps,null);
		}
		return count;
	}

	//获取满足查询条件的一条记录的对象
	/**
	 * 查询一条数据的通用方法
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public  <T> T getOneData(Class<T> clazz, String sql, Object... args){
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
			insteadHolder(ps, args);
			rs = ps.executeQuery();
			//取出rs中的值
			if (rs.next()){
				entity = getEntity(rs, clazz);
				}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}

		return entity;
	}

	//获取满足查询条件的多条记录，返回一个记录对象的集合
	public <T> List<T> getListData(Class<T> clazz, String sql, Object... args){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		T entity = null;
		List<T> list = new ArrayList<>();

		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//获取PreparedStatement
			ps = conn.prepareStatement(sql);
			//替换ps中的?占位符
			insteadHolder(ps, args);
			rs = ps.executeQuery();
			//取出rs中的值
			while (rs.next()){
				entity = getEntity(rs, clazz);
				list.add(entity);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return list;
	}

	//获取满足条件的某个字段的值或者某个统计字段（count(*)）
	public Object getOneColumn(String sql, Object... args){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//获取PreparedStatement
			ps = conn.prepareStatement(sql);
			//替换ps中的?占位符
			insteadHolder(ps, args);
			rs = ps.executeQuery();
			if (rs.next()){
				return rs.getObject(1);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return null;
	}
}
