package cn.lv.mvcproject.dao;

import cn.lv.mvcproject.model.User;

import java.sql.Connection;
import java.util.List;

/**
 * @author lv
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
	@Override
	public int save(User user) {
		String sql = "insert into `users`(`username`,`pasword`,`phone_no`,`address`,`reg_date`)value(?,?,?,?,?)";
		return super.update(sql,user.getUsername(),user.getPasword(),user.getPhoneNo(),user.getAddress(),user.getRegDate());
	}

	@Override
	public int deleteUserById(int id) {
		String sql = "delete from `users` where `id`=?";
		return super.update(sql,id);
	}

	@Override
	public int updateUserById(User user) {
		String sql = "update `users` set `username`=?,`pasword`=?,`phone_no`=?,`address`=? where `id`=?";
		return super.update(sql,user.getUsername(),user.getPasword(),user.getPhoneNo(),user.getAddress(),user.getId());
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
		String sql = "select `id`,`username`,`pasword`,`phone_no` phoneNo,`address`,`reg_date` regDate form `users`";
		return (List<User>) super.getList(sql);
	}

	@Override
	public long getCountByName(String username) {
		String sql = "select count(`id`) from `users` where `username`=?";
		return (long) super.getValue(sql,username);
	}

	@Override
	public List<User> query(String username, String address, String phoneNo) {
		String sql = "select `id`,`username`,`pasword`,`phone_no` phoneNo,`address`,`reg_date` regDate from `users` where 1=1";
		if (username!=null && !"".equals(username)){
			sql = sql + " and username like '%"+username+"%'";
		}
		if (address!=null && !"".equals(address)){
			sql = sql + " and address like '%"+address+"%'";
		}
		if (phoneNo!=null && !"".equals(phoneNo)){
			sql = sql + " and phone_no like '%"+phoneNo+"%'";
		}
		System.out.println(sql);
		return (List<User>) super.getList(sql);
	}

	@Override
	public User getUserByUP(String username, String pasword) {
		String sql = "select `id`,`username`,`pasword` from `users` where username=? and pasword=?";
		return super.get(sql,username,pasword);
	}
}
