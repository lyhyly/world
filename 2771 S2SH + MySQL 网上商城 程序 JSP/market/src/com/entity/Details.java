package com.entity;

public class Details {
	private String detailsid;

	public String getDetailsid() {
		return detailsid;
	}

	public void setDetailsid(String detailsid) {
		this.detailsid = detailsid;
	}

	private Goods goods;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	private String ordercode;

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	private String goodsid;

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	private String num;

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	private String price;

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}