package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.business.GoodsBusiness;
import com.business.BcateBusiness;
import com.business.ScateBusiness;
import com.entity.Goods;
import com.entity.Bcate;
import com.entity.Scate;
import com.util.VeDate;

public class GoodsAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Goods goods;
	private List<Goods> list;
	private GoodsBusiness goodsBusiness;
	private BcateBusiness bcateBusiness;
	private ScateBusiness scateBusiness;
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
	public String createGoods() {
		List<Bcate> bcateList = this.bcateBusiness.show();
		this.map.put("bcateList", bcateList);
		List<Scate> scateList = this.scateBusiness.show();
		this.map.put("scateList", scateList);
		return SUCCESS;
	}

	// 新增数据
	public String addGoods() {
		this.goods.setAddtime(VeDate.getStringDateShort());
		this.goods.setSellnum("0");
		this.goods.setHits("0");
		this.goodsBusiness.save(this.goods);
		return SUCCESS;
	}

	// 按主键删除 若存在子表数据 则提示异常
	public String deleteGoods() {
		try {
			this.goodsBusiness.delete(goods);
		} catch (Exception e) {
			this.map.put("msg", "存在关联项 不能删除");
		}
		return SUCCESS;
	}

	// 按主键批量删除 若存在子表数据 则提示异常
	public String deleteGoodsByIds() {
		try {
			for (String id : this.ids) {
				this.goodsBusiness.delete(id);
			}
		} catch (Exception e) {
			this.map.put("msg", "存在关联项 不能删除");
		}
		return SUCCESS;
	}

	// 更新数据
	public String updateGoods() {
		this.goodsBusiness.update(goods);
		return SUCCESS;
	}

	// 查询全部数据并输出分页代码
	public String getAllGoods() {
		this.list = new ArrayList<Goods>();
		List<Goods> tempList = new ArrayList<Goods>();
		tempList = this.goodsBusiness.show();
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
			Goods u = (Goods) tempList.get(i);
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
			buffer.append("<a href=\"goods/getAllGoods.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append(
					"<a href=\"goods/getAllGoods.action?number=" + (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append(
					"<a href=\"goods/getAllGoods.action?number=" + (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"goods/getAllGoods.action?number=" + (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	// 按主键查询 并做好修改的准备
	public String getGoodsById() {
		this.goods = this.goodsBusiness.checkId(this.id);
		List<Bcate> bcateList = this.bcateBusiness.show();
		this.map.put("bcateList", bcateList);
		List<Scate> scateList = this.scateBusiness.show();
		this.map.put("scateList", scateList);
		return SUCCESS;
	}

	// 按条件查询数据(模糊查询)
	public String queryGoodsByCond() {
		this.list = new ArrayList<Goods>();
		if ("goodsname".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeGoodsname(this.name);
		}
		if ("image".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeImage(this.name);
		}
		if ("bcateid".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeBcateid(this.name);
		}
		if ("scateid".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeScateid(this.name);
		}
		if ("marketprice".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeMarketprice(this.name);
		}
		if ("price".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikePrice(this.name);
		}
		if ("recommend".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeRecommend(this.name);
		}
		if ("special".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeSpecial(this.name);
		}
		if ("storage".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeStorage(this.name);
		}
		if ("addtime".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeAddtime(this.name);
		}
		if ("sellnum".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeSellnum(this.name);
		}
		if ("hits".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeHits(this.name);
		}
		if ("contents".equals(this.cond)) {
			list = this.goodsBusiness.checkByLikeContents(this.name);
		}
		return SUCCESS;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	public GoodsBusiness getGoodsBusiness() {
		return goodsBusiness;
	}

	public void setGoodsBusiness(GoodsBusiness goodsBusiness) {
		this.goodsBusiness = goodsBusiness;
	}

	public BcateBusiness getBcateBusiness() {
		return bcateBusiness;
	}

	public void setBcateBusiness(BcateBusiness bcateBusiness) {
		this.bcateBusiness = bcateBusiness;
	}

	public ScateBusiness getScateBusiness() {
		return scateBusiness;
	}

	public void setScateBusiness(ScateBusiness scateBusiness) {
		this.scateBusiness = scateBusiness;
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
