package com.business;
import java.util.List;
import com.dao.CartDAO;
import com.entity.Cart;
public class CartBusiness {
/** Spring IOC DAO 注入 Business * */
private CartDAO cartDAO;
public CartDAO getCartDAO() { return cartDAO; }
public void setCartDAO(CartDAO cartDAO) { this.cartDAO = cartDAO; }
/** save * */
public void save(Cart cart) {this.cartDAO.save(cart);}
/** update * */
public void update(Cart cart) {this.cartDAO.update(cart);}
/** delete * */
public void delete(String id) {this.cartDAO.delete(id);}
/** delete * */
public void delete(int id) {this.cartDAO.delete(id);}
/** delete * */
public void delete(Cart cart) {this.cartDAO.delete(cart);}
/** show * */
public List<Cart> show() {return cartDAO.show();}
/** check * */
public List<Cart> checkUsersid(String name) {return this.cartDAO.queryByUsersid(name);}
/** check * */
public List<Cart> checkGoodsid(String name) {return this.cartDAO.queryByGoodsid(name);}
/** check * */
public List<Cart> checkNum(String name) {return this.cartDAO.queryByNum(name);}
/** check * */
public List<Cart> checkPrice(String name) {return this.cartDAO.queryByPrice(name);}
/** check * */
public List<Cart> checkAddtime(String name) {return this.cartDAO.queryByAddtime(name);}
/** check * */
public List<Cart> checkByLikeUsersid(String name) {return this.cartDAO.queryLikeByUsersid(name);}
/** check * */
public List<Cart> checkByLikeGoodsid(String name) {return this.cartDAO.queryLikeByGoodsid(name);}
/** check * */
public List<Cart> checkByLikeNum(String name) {return this.cartDAO.queryLikeByNum(name);}
/** check * */
public List<Cart> checkByLikePrice(String name) {return this.cartDAO.queryLikeByPrice(name);}
/** check * */
public List<Cart> checkByLikeAddtime(String name) {return this.cartDAO.queryLikeByAddtime(name);}
/** checkId * */
public Cart checkId(String id) {return this.cartDAO.queryById(id);}

}
