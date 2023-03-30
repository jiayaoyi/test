package com.seiryo.entity;

public class userInfo {
	private Integer userId;
	private String userName;
	private String passWord;
	private String userMail;
	private Integer userMoney;
	private String userAddress;
	public userInfo(Integer userId, String userName, String passWord, String userMail, Integer userMoney,
			String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.userMail = userMail;
		this.userMoney = userMoney;
		this.userAddress = userAddress;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public Integer getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(Integer userMoney) {
		this.userMoney = userMoney;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public userInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "userInfo [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", userMail="
				+ userMail + ", userMoney=" + userMoney + ", userAddress=" + userAddress + "]";
	}
	
}
