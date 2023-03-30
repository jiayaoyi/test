package com.seiryo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.entity.cart;
import com.seiryo.entity.userInfo;
import com.seiryo.util.JDBC_Utill;

public class cartDao {

	public static boolean insertCartInfo(cart cart) {
		String sql = "INSERT INTO cart (goodsId, goodsName,goodsPrice,cartQuantity,cartDate) VALUES (?,?,?,?,?)";
		PreparedStatement pst = null;
	    boolean bo = false;
	    List<cart> newCart = new ArrayList<cart>();
	    try {
	        bo = JDBC_Utill.updateDataBase(sql,cart.getGoodsId(),cart.getGoodsName(),cart.getGoodsPrice(),cart.getCartQuantity(),cart.getCartDate());
	        if (bo ) {
	            System.out.println("加入购物车成功");
	        }
	        else {
	            System.out.println("加入购物车失败");
	        }
	        return bo;
	    } catch (Exception e) {
	        e.getStackTrace();
	    } finally {
	        try {
	            JDBC_Utill.dbClose(null, pst, null);
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return bo;
	}
	public static List<cart> selectAllCarts(){
		String sql = "Select goodsId, goodsName,goodsPrice,cartQuantity,cartDate from cart";
		ResultSet rst = null;
		List<cart> cartList = new ArrayList<cart>();
		try {
			rst = JDBC_Utill.selectDataBase(sql);
			while (rst.next()) {
				cart cart = new cart();
				cart.setGoodsId(rst.getInt("goodsId"));
				cart.setGoodsName(rst.getString("goodsName"));
				cart.setCartDate(rst.getString("cartDate"));
				cart.setCartQuantity(rst.getInt("cartQuantity"));
				cartList.add(cart);
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
		return cartList;
	}

	
}
