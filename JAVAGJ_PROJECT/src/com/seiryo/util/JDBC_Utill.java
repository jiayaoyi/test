package com.seiryo.util;
import java.sql.*;
import java.util.Scanner;

public class JDBC_Utill {
	//数据库加载
	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=shoppingMall";
	private static final String ADMIN = "sa";
	private static final String PASSWORD = "123";
	//数据库连接方法
	private static  Connection con = null;
	private static  PreparedStatement pst = null;
	private static  ResultSet rst = null;
	
	//连接数据库方法
	public static void PreparedStatement (String sql,Object...objects) throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url,ADMIN,PASSWORD);
		pst = con.prepareStatement(sql);
		for (int i = 0 ; i < objects.length;i++) {
			pst.setObject(i+1, objects[i]);
		}
	}
	//数据库增删改查方法
	//1.数据库关闭方法，此方法可以防止之前没有执行完的方法被重复执行
	public void dbClose() throws Exception {
		if (rst != null) {
			rst.close();
		}
		if (pst != null) {
			pst.close();
		}
		if (con != null) {
			con.close();
		}
	}
	//关闭外界传入的数据库连接属性
	public static void dbClose(ResultSet rst,PreparedStatement pst,Connection con) throws Exception {
		if (rst != null) {
			rst.close();
		}
		if (pst != null) {
			pst.close();
		}
		if (con != null) {
			con.close();
		}
	}
	//2.查询方法
	public static ResultSet selectDataBase(String sql,Object...objects) throws Exception {
		PreparedStatement (sql,objects);
		rst = pst.executeQuery();
		return rst; 
	}
	//3.增删改方法
	public static boolean updateDataBase (String sql,Object...objects) throws Exception {
		PreparedStatement (sql,objects);
		boolean bo = pst.executeUpdate(sql)>0?true:false;
		dbClose(rst,pst,con);
		return bo;
	}
}
