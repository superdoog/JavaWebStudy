package cn.lv.mvcproject.service;

import cn.lv.mvcproject.dao.FactoryDao;
import cn.lv.mvcproject.dao.UserDao;
import cn.lv.mvcproject.model.User;
import cn.lv.mvcproject.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author lv
 */
public class UserServiceImpl implements UserService {

	UserDao userDao = FactoryDao.getUserDao();

	@Override
	public int save(User user) {
		return userDao.save(user);
	}

	@Override
	public int deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}

	@Override
	public int updateUserById(User user) {
		return userDao.updateUserById(user);
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public User getTransaction(int id) {
		Connection conn = null;
		User user = null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			user = userDao.get(conn, id);
			conn.commit();
		}catch (Exception e){
			e.printStackTrace();
			JdbcUtils.rollbackTransaction(conn);
		}finally {
			JdbcUtils.closeConn(conn);
		}

		return user;
	}



	@Override
	public List<User> getListAll() {
		return userDao.getListAll();
	}

	@Override
	public long getCountByName(String username) {
		return userDao.getCountByName(username);
	}

	@Override
	public List<User> query(String username, String address, String phoneNo) {

		return userDao.query(username, address, phoneNo);
	}
}
