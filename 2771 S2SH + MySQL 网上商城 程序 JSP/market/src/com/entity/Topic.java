package com.entity;

public class Topic {
	private String topicid;

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}

	private Users users;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	private Goods goods;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	private String usersid;

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
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

	private String contents;

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	private String addtime;

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
}