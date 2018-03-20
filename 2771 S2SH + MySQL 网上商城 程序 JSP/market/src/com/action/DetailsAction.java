package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.business.DetailsBusiness;
import com.business.GoodsBusiness;
import com.entity.Details;
import com.entity.Goods;

public class DetailsAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Details details;
	private List<Details> list;
	private DetailsBusiness detailsBusiness;
	private GoodsBusiness goodsBusiness;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String id;
	private String[] ids;
	private String name;
	private String cond;
	private Map<String, Object> map = new HashMap<String, Object>();

	// 准备新增数据 Struts2需要由Action跳转到JSP 判断是否需要查询数据并放入下拉菜单
	public String createDetails() {
		List<Goods> goodsList = this.goodsBusiness.show();
		this.map.put("goodsList", goodsList);
		return SUCCESS;
	}

	// 新增数据
	public String addDetails() {
		this.detailsBusiness.save(this.details);
		return SUCCESS;
	}

	// 按主键删除 若存在子表数据 则提示异常
	public String deleteDetails() {
		try {
			this.detailsBusiness.delete(details);
		} catch (Exception e) {
			this.map.put("msg", "存在关联项 不能删除");
		}
		return SUCCESS;
	}

	// 按主键批量删除 若存在子表数据 则提示异常
	public String deleteDetailsByIds() {
		try {
			for (String id : this.ids) {
				this.detailsBusiness.delete(id);
			}
		} catch (Exception e) {
			this.map.put("msg", "存在关联项 不能删除");
		}
		return SUCCESS;
	}

	// 更新数据
	public String updateDetails() {
		this.detailsBusiness.update(details);
		return SUCCESS;
	}

	// 查询全部数据并输出分页代码
	public String getAllDetails() {
		this.list = new ArrayList<Details>();
		List<Details> tempList = new ArrayList<Details>();
		tempList = this.detailsBusiness.show();
		this.pageNumber = tempList.size();
		this.maxPage = this.pageNumber;
		if (this.maxPage % 10 == 0) {
			this.maxPage = this.maxPage / 10;
		} else {
			this.maxPage = this.maxPage / 10 + 1;
		}
		if (this.number == null) {
			this.number = "0";
		}
		int start = Integer.parseInt(this.number) * 10;
		int over = (Integer.parseInt(this.number) + 1) * 10;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Details u = (Details) tempList.get(i);
			this.list.add(u);
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("&nbsp;&nbsp;共为");
		buffer.append(maxPage);
		buffer.append("页&nbsp; 共有");
		buffer.append(pageNumber);
		buffer.append("条&nbsp; 当前为第");
		buffer.append((Integer.parseInt(this.number) + 1));
		buffer.append("页 &nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("首页");
		} else {
			buffer.append("<a href=\"details/getAllDetails.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"details/getAllDetails.action?number=" + (Integer.parseInt(this.number) - 1)
					+ "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"details/getAllDetails.action?number=" + (Integer.parseInt(this.number) + 1)
					+ "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"details/getAllDetails.action?number=" + (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	// 按主键查询 并做好修改的准备
	public String getDetailsById() {
		this.details = this.detailsBusiness.checkId(this.id);
		List<Goods> goodsList = this.goodsBusiness.show();
		this.map.put("goodsList", goodsList);
		return SUCCESS;
	}

	// 按条件查询数据(模糊查询)
	public String queryDetailsByCond() {
		this.list = new ArrayList<Details>();
		if ("ordercode".equals(this.cond)) {
			list = this.detailsBusiness.checkByLikeOrdercode(this.name);
		}
		if ("goodsid".equals(this.cond)) {
			list = this.detailsBusiness.checkByLikeGoodsid(this.name);
		}
		if ("num".equals(this.cond)) {
			list = this.detailsBusiness.checkByLikeNum(this.name);
		}
		if ("price".equals(this.cond)) {
			list = this.detailsBusiness.checkByLikePrice(this.name);
		}
		return SUCCESS;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public List<Details> getList() {
		return list;
	}

	public void setList(List<Details> list) {
		this.list = list;
	}

	public DetailsBusiness getDetailsBusiness() {
		return detailsBusiness;
	}

	public void setDetailsBusiness(DetailsBusiness detailsBusiness) {
		this.detailsBusiness = detailsBusiness;
	}

	public GoodsBusiness getGoodsBusiness() {
		return goodsBusiness;
	}

	public void setGoodsBusiness(GoodsBusiness goodsBusiness) {
		this.goodsBusiness = goodsBusiness;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

}
