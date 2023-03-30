package com.seiryo.entity;

public class goods {
	  private int goodsId;
	  private String goodsName;
	  private double goodsPrice;
	  private int goodsStock;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsSock() {
		return goodsStock;
	}
	public void setGoodsSock(int goodsSock) {
		this.goodsStock = goodsSock;
	}
	public goods(int goodsId, String goodsName, double goodsPrice, int goodsSock) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsStock = goodsSock;
	}
	public goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", goodsSock="
				+ goodsStock + "]";
	}
	  

	}

