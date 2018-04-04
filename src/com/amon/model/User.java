package com.amon.model;
/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月28日 下午6:13:11
* 类说明
*/
public class User {
	private int id;
	private String userName;
	private String passWord;
	private int userType;
	
	public User(String userName) {
		this.userName = userName;
	}
	


	public User(int id, int userType) {
		super();
		this.id = id;
		this.userType = userType;
	}



	public User(int id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public User(String userName, String passWord, int userType) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.userType = userType;
	}
	
	public User(int userId) {
		this.id=userId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
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
	
}
