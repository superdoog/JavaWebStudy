package cn.lv.model;

import java.util.Date;


/**
 * 用户实体类
 */
public class User {
	//用户编号
	private int id;
	//用户名称
	private String userName;
	//用户密码
	private String password;
	//用户电话
	private String phoneNo;
	//用户地址
	private String address;
	//用户注册日期
	private Date regDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public User() {
	}

	public User(int id, String userName, String password, String phoneNo, String address, Date regDate) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.phoneNo = phoneNo;
		this.address = address;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", phoneNo='" + phoneNo + '\'' +
				", address='" + address + '\'' +
				", regDate=" + regDate +
				'}';
	}
}
