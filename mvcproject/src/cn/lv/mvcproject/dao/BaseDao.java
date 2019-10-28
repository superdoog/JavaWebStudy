package cn.lv.mvcproject.dao;

import cn.lv.mvcproject.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;

/**
 * 这是一个dao层里的基本类
 * 被具体的dao类继承
 * 不能new对象
 * @author lv
 * @param <T> 针对要操作各张表映射到java工程里的Java类
 */
public class BaseDao<T> {
	//对数据库有增删改查

	QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	/**
	 * 用构造方法初始化clazz
	 */
	public BaseDao(){
		//getGenericSuperclass 拿到调用者父类的类型
		Type superType = this.getClass().getGenericSuperclass();
		if (superType instanceof ParameterizedType){
			ParameterizedType pt = (ParameterizedType) superType;
			Type[] tarry = pt.getActualTypeArguments();
			if (tarry[0] instanceof Class){
				clazz = (Class<T>) tarry[0];
			}
		}
	}

	/**
	 * 查询数据表，取出sql语句的结果集的第一条数据，封装成一个类的对象返回
	 * 不支持事务
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object...args){
		Connection conn = null;
		T entity = null;
		try {
			conn = JdbcUtils.getConnection();
			entity = queryRunner.query(conn,sql, new BeanHandler<T>(clazz), args);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConn(conn);
		}
		return entity;
	}

	/**
	 * 查询数据表，取出sql语句的结果集的第一条数据，封装成一个类的对象返回
	 * 支持事务
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(Connection conn, String sql, Object...args){
		T entity = null;
		try {
			entity = queryRunner.query(conn,sql, new BeanHandler<T>(clazz), args);
		}catch (Exception e){
			e.printStackTrace();
		}
		return entity;
	}


}
