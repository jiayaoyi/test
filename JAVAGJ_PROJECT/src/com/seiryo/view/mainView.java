package com.seiryo.view;

import java.util.*;

import com.seiryo.util.*;
import com.seiryo.dao.userDao;
import com.seiryo.entity.*;

public class mainView {
	boolean loginFlag = true;
	private  userDao userDao = new userDao();
	public void mainView() {
		System.out.println("欢迎使用购物商城");
		System.out.println("===============");
		System.out.println("请输入数字，进入对应功能：");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("3.退出");
		String num =  ScannerUtil.getScanner().next();
		if ("1".equals(num)) {
			Login();
		}
		else if ("2".equals(num)) {
			Login(); 
		}
		else if ("3".equals(num)) {
			System.err.println("欢迎下次光临!");
		}
		else {
			System.out.println("请输入正确的数字");
		}
	}
	public void Login() {
		//查询数据库
		List<userInfo> userList = userDao.selectAllUsers();
		System.out.println("请输入账号");
		String account = ScannerUtil.getScanner().next();
		System.out.println("请输入密码");
		String loginPass = ScannerUtil.getScanner().next();
		if (userList.size()>0) {
			for (userInfo u : userList) {
				//遍历，同时核对账号密码
				if (u.getUserName().equals(account) && u.getPassWord().equals(loginPass)) {
					System.out.println("登录成功");
					loginFlag = true;//登录标识为真，进入主界面
					return;
				}
				else {
					loginFlag = false;
				}
			}
			System.out.println("您输入的账号不存在");
			
		} else {
			System.out.println("请先注册后登录");
		}
		if (loginFlag) {
			mainMenu.menu();
		}
	}
	public void register() {
		boolean flag = true;
		userInfo newUser = new userInfo();
		System.out.println("欢迎使用注册系统");
		System.out.println("请输入注册账号");
		String userName = ScannerUtil.getScanner().next();
		List<userInfo> userList = userDao.selectAllUsers();
		// Check if the entered username is already registered
		for (userInfo u : userList) {
		  if (u.getUserName().equals(userName)) {
		    System.out.println("您输入的账号已经被注册");
		    flag = false;
		    break;
		  }
		}
		if (flag) {
			System.out.println("请输入密码");
			String userPass = ScannerUtil.getScanner().next();
			System.out.println("请输入邮箱");
			String userMail = ScannerUtil.getScanner().next();
			System.out.println("请输入地址");
			String userAddress = ScannerUtil.getScanner().next();
			System.out.println("username"+userName);
			newUser.setUserName(userName);
			newUser.setPassWord(userPass);
			newUser.setUserMail(userMail);
			newUser.setUserAddress(userAddress);
			com.seiryo.dao.userDao.updateNewUsers(newUser);
		}
	}
	public void menu() {
		checkGoods checkGoods = new checkGoods();
		System.out.println("欢迎使用网络商城");
		System.out.println("===============");
		System.out.println("1.查看商品");
		System.out.println("2.查看购物车");
		System.out.println("3.查看订单");
		System.out.println("4.我的信息");
		System.out.println("5.退出系统");
		System.out.println("================");
		System.out.println("请输入对应编号");
		String choseBox = ScannerUtil.getScanner().next();
		if (choseBox.equals(1)) {
			checkGoods.checkGoods();
		}
	}

}
