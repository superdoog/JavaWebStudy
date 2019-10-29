package cn.lv.mvcproject.dao;

public class FactoryDao {

	public static UserDao getUserDao(){
		return new UserDaoImpl();
	}
}
