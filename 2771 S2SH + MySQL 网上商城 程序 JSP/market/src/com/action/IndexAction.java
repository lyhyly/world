package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.business.ArticleBusiness;
import com.business.BcateBusiness;
import com.business.CartBusiness;
import com.business.DetailsBusiness;
import com.business.GoodsBusiness;
import com.business.OrdersBusiness;
import com.business.ScateBusiness;
import com.business.TopicBusiness;
import com.business.UsersBusiness;
import com.entity.Article;
import com.entity.Bcate;
import com.entity.Cart;
import com.entity.Details;
import com.entity.Goods;
import com.entity.Orders;
import com.entity.Scate;
import com.entity.Topic;
import com.entity.Users;
import com.util.VeDate;

public class IndexAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private String id;
	private String msg;
	private String name;
	private String cond;
	private String num;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String username;
	private String password;
	private String repassword;
	private String newpassword;
	private String title = "网上商城";
	private String code;

	private Users users;
	private Cart cart;
	private Topic topic;

	private Map<String, Object> map = new HashMap<String, Object>();

	private ArticleBusiness articleBusiness;
	private CartBusiness cartBusiness;
	private UsersBusiness usersBusiness;
	private GoodsBusiness goodsBusiness;
	private BcateBusiness bcateBusiness;
	private ScateBusiness scateBusiness;
	private OrdersBusiness ordersBusiness;
	private DetailsBusiness detailsBusiness;
	private TopicBusiness topicBusiness;

	private void init() {
		List<Bcate> bcateList = this.bcateBusiness.show();
		List<Bcate> cateList = new ArrayList<Bcate>();
		for (Bcate cate : bcateList) {
			List<Scate> scateList = this.scateBusiness.checkBcateid(cate.getBcateid());
			cate.setScateList(scateList);
			cateList.add(cate);
		}
		this.map.put("cateList", cateList);
		List<Goods> hotList = this.goodsBusiness.hot();
		this.map.put("hotList", hotList);
	}

	public String index() {
		this.init();
		List<Bcate> bcateList = this.bcateBusiness.front();
		List<Bcate> frontList = new ArrayList<Bcate>();
		for (Bcate cate : bcateList) {
			List<Scate> scateList = this.scateBusiness.checkBcateid(cate.getBcateid());
			cate.setScateList(scateList);
			List<Goods> goodsList = this.goodsBusiness.front(cate.getBcateid());
			cate.setGoodsList(goodsList);
			frontList.add(cate);
		}
		this.map.put("frontList", frontList);
		return SUCCESS;
	}

	public String bcate() {
		this.init();
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Goods> tempList = this.goodsBusiness.checkBcateid(this.id);
		this.pageNumber = tempList.size();
		this.maxPage = this.pageNumber;
		if (this.maxPage % 8 == 0) {
			this.maxPage = this.maxPage / 8;
		} else {
			this.maxPage = this.maxPage / 8 + 1;
		}
		if (this.number == null) {
			this.number = "0";
		}
		int start = Integer.parseInt(this.number) * 8;
		int over = (Integer.parseInt(this.number) + 1) * 8;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Goods u = (Goods) tempList.get(i);
			goodsList.add(u);
		}
		this.map.put("goodsList", goodsList);
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
			buffer.append("<a href=\"index/bcate.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"index/bcate.action?number=" + (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"index/bcate.action?number=" + (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"index/bcate.action?number=" + (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String scate() {
		this.init();
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Goods> tempList = this.goodsBusiness.checkScateid(this.id);
		this.pageNumber = tempList.size();
		this.maxPage = this.pageNumber;
		if (this.maxPage % 8 == 0) {
			this.maxPage = this.maxPage / 8;
		} else {
			this.maxPage = this.maxPage / 8 + 1;
		}
		if (this.number == null) {
			this.number = "0";
		}
		int start = Integer.parseInt(this.number) * 8;
		int over = (Integer.parseInt(this.number) + 1) * 8;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Goods u = (Goods) tempList.get(i);
			goodsList.add(u);
		}
		this.map.put("goodsList", goodsList);
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
			buffer.append("<a href=\"index/scate.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"index/scate.action?number=" + (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"index/scate.action?number=" + (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"index/scate.action?number=" + (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String special() {
		this.init();
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Goods> tempList = this.goodsBusiness.checkSpecial("是");
		this.pageNumber = tempList.size();
		this.maxPage = this.pageNumber;
		if (this.maxPage % 8 == 0) {
			this.maxPage = this.maxPage / 8;
		} else {
			this.maxPage = this.maxPage / 8 + 1;
		}
		if (this.number == null) {
			this.number = "0";
		}
		int start = Integer.parseInt(this.number) * 8;
		int over = (Integer.parseInt(this.number) + 1) * 8;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Goods u = (Goods) tempList.get(i);
			goodsList.add(u);
		}
		this.map.put("goodsList", goodsList);
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
			buffer.append("<a href=\"index/special.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append(
					"<a href=\"index/special.action?number=" + (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append(
					"<a href=\"index/special.action?number=" + (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"index/special.action?number=" + (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String recommend() {
		this.init();
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Goods> tempList = this.goodsBusiness.checkRecommend("是");
		this.pageNumber = tempList.size();
		this.maxPage = this.pageNumber;
		if (this.maxPage % 8 == 0) {
			this.maxPage = this.maxPage / 8;
		} else {
			this.maxPage = this.maxPage / 8 + 1;
		}
		if (this.number == null) {
			this.number = "0";
		}
		int start = Integer.parseInt(this.number) * 8;
		int over = (Integer.parseInt(this.number) + 1) * 8;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Goods u = (Goods) tempList.get(i);
			goodsList.add(u);
		}
		this.map.put("goodsList", goodsList);
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
			buffer.append("<a href=\"index/recommend.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append(
					"<a href=\"index/recommend.action?number=" + (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append(
					"<a href=\"index/recommend.action?number=" + (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"index/recommend.action?number=" + (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String all() {
		this.init();
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Goods> tempList = this.goodsBusiness.show();
		this.pageNumber = tempList.size();
		this.maxPage = this.pageNumber;
		if (this.maxPage % 8 == 0) {
			this.maxPage = this.maxPage / 8;
		} else {
			this.maxPage = this.maxPage / 8 + 1;
		}
		if (this.number == null) {
			this.number = "0";
		}
		int start = Integer.parseInt(this.number) * 8;
		int over = (Integer.parseInt(this.number) + 1) * 8;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Goods u = (Goods) tempList.get(i);
			goodsList.add(u);
		}
		this.map.put("goodsList", goodsList);
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
			buffer.append("<a href=\"index/all.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"index/all.action?number=" + (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"index/all.action?number=" + (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"index/all.action?number=" + (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String query() {
		this.init();
		List<Goods> goodsList = this.goodsBusiness.checkByLikeGoodsname(this.name);
		this.map.put("goodsList", goodsList);
		return SUCCESS;
	}

	public String detail() {
		this.init();
		Goods goods = this.goodsBusiness.checkId(this.id);
		goods.setHits("" + (Integer.parseInt(goods.getHits()) + 1));
		this.goodsBusiness.update(goods);
		this.map.put("goods", goods);
		List<Topic> topicList = this.topicBusiness.checkGoodsid(this.id);
		this.map.put("topicList", topicList);
		this.map.put("tnum", topicList.size());
		return SUCCESS;
	}

	// 新闻公告
	public String addTopic() {
		this.init();
		String userid = (String) session.get("userid");
		this.topic.setAddtime(VeDate.getStringDateShort());
		this.topic.setUsersid(userid);
		this.topicBusiness.save(this.topic);
		return SUCCESS;
	}

	// 新闻公告
	public String article() {
		this.init();
		List<Article> articleList = this.articleBusiness.show();
		this.map.put("articleList", articleList);
		return SUCCESS;
	}

	public String read() {
		this.init();
		Article article = this.articleBusiness.checkId(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleBusiness.update(article);
		this.map.put("article", article);
		return SUCCESS;
	}

	public String preLogin() {
		this.init();
		return SUCCESS;
	}

	public String login() {
		this.init();
		List<Users> usersList = this.usersBusiness.checkUsername(this.users.getUsername());
		if (usersList.size() == 0) {
			return "usererror";
		} else {
			Users user = usersList.get(0);
			if (user.getPassword().equals(this.users.getPassword())) {
				session.put("userid", user.getUsersid());
				session.put("username", user.getUsername());
				session.put("realname", user.getRealname());
				session.put("users", user);
			} else {
				this.session.put("message", "密码错误");
				return "usererror";
			}
		}
		return "success";
	}

	public String prePwd() {
		this.init();
		return SUCCESS;
	}

	public String editPwd() {
		List<Users> usersList = this.usersBusiness.checkUsername(this.users.getUsername());
		if (usersList.size() == 0) {

		} else {
			Users users1 = usersList.get(0);
			if (users1.getPassword().equals(this.users.getPassword())) {
				users1.setPassword(this.repassword);
				this.usersBusiness.update(users1);
				session.put("users", users1);
				this.session.put("message", "修改成功");
			} else {
				this.session.put("message", "旧密码错误");
			}
		}
		return SUCCESS;
	}

	public String preReg() {
		this.init();
		return SUCCESS;
	}

	public String reg() {
		this.init();
		this.users.setRegdate(VeDate.getStringDateShort());
		this.usersBusiness.save(this.users);
		return SUCCESS;
	}

	public String usercenter() {
		this.init();
		return SUCCESS;
	}

	public String personal() {
		this.init();
		this.usersBusiness.update(users);
		session.put("users", users);
		return SUCCESS;
	}

	public String exit() {
		session.clear();
		return SUCCESS;
	}

	public String addCart() {
		this.init();
		String userid = (String) this.session.get("userid");
		this.cart.setAddtime(VeDate.getStringDateShort());
		this.cart.setUsersid(userid);
		this.cartBusiness.save(this.cart);
		return SUCCESS;
	}

	public String cart() {
		this.init();
		String userid = (String) this.session.get("userid");
		List<Cart> cartList = this.cartBusiness.checkUsersid(userid);
		this.map.put("cartList", cartList);
		String total = "0";
		for (Cart cart : cartList) {
			total = "" + (Double.parseDouble(total)
					+ Double.parseDouble(cart.getPrice()) * Double.parseDouble(cart.getNum()));
		}
		this.map.put("total", total);
		return SUCCESS;
	}

	public String deleteCart() {
		this.init();
		this.cartBusiness.delete(this.id);
		return SUCCESS;
	}

	public String preCheckout() {
		this.init();
		String userid = (String) this.session.get("userid");
		List<Cart> cartList = this.cartBusiness.checkUsersid(userid);
		if (cartList.size() == 0) {
			return "fail";
		}
		return SUCCESS;
	}

	public String checkout() {
		this.init();
		String userid = (String) this.session.get("userid");
		List<Cart> cartList = this.cartBusiness.checkUsersid(userid);
		String ordersid = "CO" + VeDate.getStringDatex();
		double total = 0;
		for (Cart cart : cartList) {
			Details item = new Details();
			item.setGoodsid(cart.getGoodsid());
			item.setNum(cart.getNum());
			item.setOrdercode(ordersid);
			item.setPrice(cart.getGoods().getPrice());
			this.detailsBusiness.save(item);
			total += Double.parseDouble(cart.getPrice()) * Double.parseDouble(cart.getNum());
			this.cartBusiness.delete(cart);
			Goods goods = this.goodsBusiness.checkId(cart.getGoodsid());
			goods.setSellnum("" + (Integer.parseInt(goods.getSellnum()) + Integer.parseInt(cart.getNum())));
			this.goodsBusiness.update(goods);
		}
		Orders orders = new Orders();
		orders.setAddress(this.cond);
		orders.setAddtime(VeDate.getStringDate());
		orders.setContact(this.msg);
		orders.setOrdercode(ordersid);
		orders.setReceiver(this.name);
		orders.setStatus("未付款");
		orders.setTotal("" + total);
		orders.setUsersid(userid);
		this.ordersBusiness.save(orders);
		return SUCCESS;
	}

	public String showOrders() {
		this.init();
		String userid = (String) this.session.get("userid");
		List<Orders> ordersList = this.ordersBusiness.checkUsersid(userid);
		this.map.put("ordersList", ordersList);
		return SUCCESS;
	}

	public String orderdetail() {
		this.init();
		List<Details> itemList = this.detailsBusiness.checkOrdercode(this.id);
		this.map.put("itemList", itemList);
		return SUCCESS;
	}

	public String deleteOrders() {
		this.init();
		Orders orders = this.ordersBusiness.checkId(this.id);
		List<Details> itemList = this.detailsBusiness.checkOrdercode(orders.getOrdercode());
		for (Details item : itemList) {
			this.detailsBusiness.delete(item);
		}
		this.ordersBusiness.delete(this.id);
		return SUCCESS;
	}

	public String prePay() {
		this.init();
		return SUCCESS;
	}

	public String pay() {
		this.init();
		// 检查验证码
		String checkCode = (String) session.get("checkCode");
		if (!checkCode.equals(this.code)) {
			this.session.put("message", "验证码错误");
			return "payerror";
		} else {
			Orders orders = this.ordersBusiness.checkId(this.id);
			orders.setStatus("已付款");
			this.ordersBusiness.update(orders);
			List<Details> itemList = this.detailsBusiness.checkOrdercode(orders.getOrdercode());
			for (Details item : itemList) {
				Goods goods = this.goodsBusiness.checkId(item.getGoodsid());
				goods.setSellnum("" + (Integer.parseInt(goods.getSellnum()) + Integer.parseInt(item.getNum())));
				this.goodsBusiness.update(goods);
			}
		}
		return SUCCESS;
	}

	public String over() {
		this.init();
		Orders orders = this.ordersBusiness.checkId(this.id);
		orders.setStatus("完成");
		this.ordersBusiness.update(orders);
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public ArticleBusiness getArticleBusiness() {
		return articleBusiness;
	}

	public void setArticleBusiness(ArticleBusiness articleBusiness) {
		this.articleBusiness = articleBusiness;
	}

	public CartBusiness getCartBusiness() {
		return cartBusiness;
	}

	public void setCartBusiness(CartBusiness cartBusiness) {
		this.cartBusiness = cartBusiness;
	}

	public UsersBusiness getUsersBusiness() {
		return usersBusiness;
	}

	public void setUsersBusiness(UsersBusiness usersBusiness) {
		this.usersBusiness = usersBusiness;
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

	public OrdersBusiness getOrdersBusiness() {
		return ordersBusiness;
	}

	public void setOrdersBusiness(OrdersBusiness ordersBusiness) {
		this.ordersBusiness = ordersBusiness;
	}

	public DetailsBusiness getDetailsBusiness() {
		return detailsBusiness;
	}

	public void setDetailsBusiness(DetailsBusiness detailsBusiness) {
		this.detailsBusiness = detailsBusiness;
	}

	public TopicBusiness getTopicBusiness() {
		return topicBusiness;
	}

	public void setTopicBusiness(TopicBusiness topicBusiness) {
		this.topicBusiness = topicBusiness;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

}
