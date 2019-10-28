package cn.lv.mvcproject.model;

import java.util.Date;

/**
 * 用户类
 */

public class User {

	//用户编号
	private int id;
	//用户名称
	private String username;
	//用户密码
	private String pasword;
	//用户电话
	private String phoneNo;
	//用户地址
	private String address;
	//用户注册时间
	private Date regDate;

	public User() {
	}

	public User(int id, String username, String pasword, String phoneNo, String address, Date regDate) {
		this.id = id;
		this.username = username;
		this.pasword = pasword;
		this.phoneNo = phoneNo;
		this.address = address;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", pasword='" + pasword + '\'' +
				", phoneNo='" + phoneNo + '\'' +
				", address='" + address + '\'' +
				", regDate=" + regDate +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
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
}
