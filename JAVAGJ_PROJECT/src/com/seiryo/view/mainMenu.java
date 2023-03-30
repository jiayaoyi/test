package com.seiryo.view;

import com.seiryo.entity.*;
import com.seiryo.util.ScannerUtil;

public class mainMenu {
	public static void menu() {
		checkGoods checkGoods = new checkGoods();
		checkCart checkCart = new checkCart();
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
		if (choseBox.equals(2)) {
			checkCart.checkCart();
		}
	}
}
