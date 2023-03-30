package com.seiryo.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.dao.cartDao;
import com.seiryo.dao.goodsDao;
import com.seiryo.entity.cart;
import com.seiryo.entity.goods;
import com.seiryo.util.ScannerUtil;

public class checkGoods {
	public void checkGoods() {
		List<goods> goodsList = goodsDao.selectAllGoods();
		List<cart> cartList = new ArrayList<>();
		if (goodsList.size() > 0) {
			for (goods goods : goodsList) {
				System.out.println("商品编号：" + goods.getGoodsId() + " 商品名称：" + goods.getGoodsName() + " 商品价格：" + goods.getGoodsPrice() + " 商品库存：" + goods.getGoodsSock());
			}
		} else {
			System.out.println("目前没有商品");
		}
		System.out.println("请输入想购买的商品编号");
		System.out.println("=====================");
		String cartID = ScannerUtil.getScanner().next();
		for (goods goods : goodsList) {
			if (cartID.equals(String.valueOf(goods.getGoodsId()))) {
				System.out.println("请输入想购买的数量");
				int cartQuantity = ScannerUtil.getScanner().nextInt();
				if (cartQuantity <= goods.getGoodsSock() && cartQuantity > 0) {
					System.out.println("您将购买" + cartQuantity + "个" + goods.getGoodsName());
					goods.setGoodsSock(goods.getGoodsSock() - cartQuantity);
					int goodsId = goods.getGoodsId();
					String goodsName = goods.getGoodsName();
					String cartDate = today();
					double goodsPrice = goods.getGoodsPrice();
					cart cart = new cart();
					cart.setGoodsId(goodsId);
					cart.setGoodsName(goodsName);
					cart.setCartDate(cartDate);
					cart.setGoodsPrice(goodsPrice);
					cart.setCartQuantity(cartQuantity);
				} else {
					System.out.println("请输入正确的数字");
					return;
				}
			}
		}
		System.out.println("请问是否继续购买？请输入yes继续购买或no返回主菜单");
		String yon = ScannerUtil.getScanner().next();
		if (yon.equals("yes")) {
			checkGoods();
		} else if (yon.equals("no")) {
			mainView m = new mainView();
			m.mainView();
		}
	}

	public static String today() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return formatter.format(today);
	}

	public void insertCart(int goodsId, String goodsName, String cartDate, double goodsPrice, int cartQuantity) {
		cart cart = new cart();
		cart.setGoodsId(goodsId);
		cart.setGoodsName(goodsName);
		cart.setCartDate(cartDate);
		cart.setGoodsPrice(goodsPrice);
		cart.setCartQuantity(cartQuantity);
	}
}

