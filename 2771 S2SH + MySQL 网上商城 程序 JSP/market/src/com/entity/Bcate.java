package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Bcate {
	private String bcateid;

	public String getBcateid() {
		return bcateid;
	}

	public void setBcateid(String bcateid) {
		this.bcateid = bcateid;
	}

	private String bcatename;

	public String getBcatename() {
		return this.bcatename;
	}

	public void setBcatename(String bcatename) {
		this.bcatename = bcatename;
	}

	private List<Scate> scateList = new ArrayList<Scate>();

	public List<Scate> getScateList() {
		return scateList;
	}

	public void setScateList(List<Scate> scateList) {
		this.scateList = scateList;
	}

	private List<Goods> goodsList = new ArrayList<Goods>();

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

}