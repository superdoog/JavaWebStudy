package cn.lv.mvcproject.dao;

import cn.lv.mvcproject.model.User;

import java.sql.Connection;
import java.util.List;

/**
 * 定义有关users数据表有关的操作方法
 * @author lv
 */
public interface UserDao {

	/**
	 * 插入一条数据
	 * @param user
	 * @return
	 */
	public int save(User user);

	/**
	 * 根据用户id删除对应的用户数据
	 * @param id
	 * @return
	 */
	public int deleteUserById(int id);

	/**
	 * 根据用户id修改对应的用户数据
	 * @param user
	 * @return
	 */
	public int updateUserById(User user);

	/**
	 * 根据用户编号获取一条用户数据，封装成User的一个对象
	 * 不支持事务
	 * @param id
	 * @return
	 */
	public User get(int id);

	/**
	 * 根据用户编号获取一条用户数据，封装成User的一个对象
	 * 支持事务
	 * @param id
	 * @param conn
	 * @return
	 */
	public User get(Connection conn, int id);


	/**
	 * 获取所有的用户数据
	 * @return
	 */
	public List<User> getListAll();

	/**
	 * 查询指定用户名的用户有多少条
	 * @param username
	 * @return
	 */
	public long getCountByName(String username);


	/**
	 * Dao层里实现模糊查询
	 * @param username
	 * @param address
	 * @param phoneNo
	 * @return
	 */
	List<User> query(String username, String address, String phoneNo);
}
