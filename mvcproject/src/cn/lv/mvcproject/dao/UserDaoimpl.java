package cn.lv.mvcproject.dao;

import cn.lv.mvcproject.model.User;

import java.sql.Connection;
import java.util.List;

public class UserDaoimpl extends BaseDao<User> implements UserDao {
	@Override
	public int save(User use) {
		return 0;
	}

	@Override
	public int deleteUserById(int id) {
		return 0;
	}

	@Override
	public int updateUserById(int id) {
		return 0;
	}

	@Override
	public User get(int id) {
		String sql = "select `id`,`username`,`pasword`,`phone_no` phoneNo,`address`,`reg_date` regDate from `users` where `id`=?";
		return  super.get(sql,id);
	}

	@Override
	public User get(Connection conn, int id) {
		String sql = "select `id`,`username`,`pasword`,`phone_no` phoneNo,`address`,`reg_date` regDate from `users` where `id`=?";
		return  super.get(conn,sql,id);
	}

	@Override
	public List<User> getListAll() {
		return null;
	}

	@Override
	public int getCountByName(String username) {
		return 0;
	}
}
