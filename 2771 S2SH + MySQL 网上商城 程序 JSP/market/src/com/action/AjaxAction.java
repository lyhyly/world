package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.business.CartBusiness;
import com.business.ScateBusiness;
import com.business.UsersBusiness;
import com.entity.Cart;
import com.entity.Scate;
import com.entity.Users;

public class AjaxAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private String id = "";
	private ScateBusiness scateBusiness;
	private UsersBusiness usersBusiness;
	private CartBusiness cartBusiness;

	public void ajax() {
		String JSON_text = "";
		if ("".equals(this.id)) {
			JSON_text = "[{optionValue:'',optionDisplay:'---请选择商品小类--'}]";
		} else {
			List<Scate> scateList = scateBusiness.checkBcateid(this.id);
			if (scateList.size() > 0) {
				JSON_text = "[{optionValue:'',optionDisplay:'---请选择商品小类---'},";
				for (int i = 0; i < scateList.size(); i++) {
					Scate sub = scateList.get(i);
					JSON_text += "{optionValue:'" + sub.getScateid() + "',optionDisplay:'" + sub.getScatename() + "'}";
					if (i < scateList.size() - 1) {
						JSON_text += ", ";
					} else if (i == scateList.size() - 1) {
						JSON_text += "]";
					}
				}
			} else {
				JSON_text = "[{optionValue:'',optionDisplay:'---请选择商品小类---'},";
			}
		}
		PrintWriter out = null;
		try {
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			out = ServletActionContext.getResponse().getWriter();
		} catch (IOException ex) {
		}
		this.id = "";
		out.write(JSON_text);
		out.close();
	}

	public void getUsername() {
		String JSON_text = "";
		if ("".equals(this.id)) {
			JSON_text = "[{value:'false'}]";
		} else {
			List<Users> list = this.usersBusiness.checkUsername(this.id);
			if (list.size() != 0) {
				JSON_text = "[{value:'false'}]";
			} else {
				JSON_text = "[{value:'true'}]";
			}
		}
		PrintWriter out = null;
		try {
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			out = ServletActionContext.getResponse().getWriter();
		} catch (IOException ex) {
		}
		this.id = "";
		out.write(JSON_text);
		out.close();
	}

	public void getCart() {
		String JSON_text = "";
		if ("".equals(this.id)) {
			JSON_text = "[{status:'false',num:'0',sum:'0',total:'0'}]";
		} else {
			String[] str = this.id.split(",");
			double total = 0;
			double sum = 0;
			Cart cart = this.cartBusiness.checkId(str[2]);
			cart.setNum(str[0]);
			this.cartBusiness.update(cart);
			sum = Double.parseDouble(cart.getNum()) * Double.parseDouble(cart.getPrice());
			List<Cart> cartList = this.cartBusiness.checkUsersid(str[1]);
			for (Cart c : cartList) {
				total += Double.parseDouble(c.getNum()) * Double.parseDouble(c.getPrice());
			}
			JSON_text = "[{status:'true',sum:'" + sum + "',total:'" + total + "'}]";
			System.out.println(JSON_text);
		}
		PrintWriter out = null;
		try {
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			out = ServletActionContext.getResponse().getWriter();
		} catch (IOException ex) {
		}
		this.id = "";
		out.write(JSON_text);
		out.close();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ScateBusiness getScateBusiness() {
		return scateBusiness;
	}

	public void setScateBusiness(ScateBusiness scateBusiness) {
		this.scateBusiness = scateBusiness;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UsersBusiness getUsersBusiness() {
		return usersBusiness;
	}

	public void setUsersBusiness(UsersBusiness usersBusiness) {
		this.usersBusiness = usersBusiness;
	}

	public CartBusiness getCartBusiness() {
		return cartBusiness;
	}

	public void setCartBusiness(CartBusiness cartBusiness) {
		this.cartBusiness = cartBusiness;
	}

}
