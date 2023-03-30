package com.seiryo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.entity.goods;
import com.seiryo.entity.userInfo;
import com.seiryo.util.JDBC_Utill;

public class goodsDao {
	public static List<goods> selectAllGoods(){
		String sql = "Select goodsId,goodsName,goodsPrice,goodsStock from goods";
		ResultSet rst = null;
		List<goods> goodsList = new ArrayList<goods>();
		try {
			rst = JDBC_Utill.selectDataBase(sql);
			while (rst.next()) {
				goods goods = new goods();
				goods.setGoodsId(rst.getInt("goodsId"));
				goods.setGoodsName(rst.getString("goodsName"));
				goods.setGoodsPrice(rst.getDouble("goodsPrice"));
				goods.setGoodsSock(rst.getInt("goodsStock"));
				goodsList.add(goods);
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
		return goodsList;
	}
}
