package com.seiryo.view;

import java.util.*;

import com.seiryo.dao.cartDao;
import com.seiryo.entity.cart;
import com.seiryo.entity.goods;
import com.seiryo.util.ScannerUtil;

public class checkCart {
	public void checkCart() {
		List<cart> cartList = cartDao.selectAllCarts();
		if (cartList.size() > 0) {
			for (cart cart : cartList) {
				System.out.println("商品编号：" + cart.getGoodsId() + " 商品名称：" + cart.getGoodsName() + " 商品价格：" +cart.getGoodsPrice() + " 商品库存：" + cart.getCartQuantity());
			}
		} else {
			System.out.println("目前没有商品");
		}
		System.out.println("请问您要结账吗？输入yes结账，输入其他任意键返回主菜单");
		String yon = ScannerUtil.getScanner().next();
		if (yon.equals("yes")) {
			//结账方法
		}
		else {
			//返回主菜单
			mainMenu.menu();
		}
	}
}
