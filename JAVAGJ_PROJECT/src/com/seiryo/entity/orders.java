package com.seiryo.entity;

public class orders {
    private int goodsId;
    private String goodsName;
    private String orderDate;
    private int orderQuantity;
	public orders(int orderId, String goodsName, String orderDate, int orderQuantity) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.orderDate = orderDate;
		this.orderQuantity = orderQuantity;
	}
	public orders() {
		super();
		// TODO Auto-generated constructor stub
	}
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
	@Override
	public String toString() {
		return "orders [orderId=" + goodsId + ", goodsName=" + goodsName + ", orderDate=" + orderDate
				+ ", orderQuantity=" + orderQuantity + "]";
	}
    
}
