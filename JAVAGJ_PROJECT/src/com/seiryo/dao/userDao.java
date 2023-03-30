package com.seiryo.dao;

import java.sql.*;
import java.util.*;

import com.seiryo.entity.userInfo;
import com.seiryo.util.JDBC_Utill;

import com.seiryo.util.*;
public class userDao {
	public List<userInfo> selectAllUsers(){
		String sql = "Select userId,userName,passWord,userMoney,userAddress from userInfo";
		ResultSet rst = null;
		List<userInfo> userList = new ArrayList<userInfo>();
		try {
			rst = JDBC_Utill.selectDataBase(sql);
			while (rst.next()) {
				userInfo userInfo = new userInfo();
				userInfo.setUserId(rst.getInt("userId"));
				userInfo.setUserName(rst.getString("userName"));
				userInfo.setPassWord(rst.getString("passWord"));
				userInfo.setUserMail(rst.getString("userMail"));
				userInfo.setUserMoney(rst.getInt("userMoney"));
				userInfo.setUserAddress(rst.getString("userAddress"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBC_Utill.dbClose(rst, null, null);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return userList;
	}
	public static List<userInfo> updateNewUsers(userInfo userInfo){
		String sql = "INSERT INTO userInfo (userName, passWord,userMail,userAddress) VALUES (?, ?, ?,?)";
		PreparedStatement pst = null;
		boolean bo = false;
		List<userInfo> newUser = new ArrayList<userInfo>();
		try {
			JDBC_Utill.updateDataBase(sql,userInfo.getUserName(),userInfo.getPassWord(),userInfo.getUserMail(),userInfo.getUserAddress());
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
}
