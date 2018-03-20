package com.business;
import java.util.List;
import com.dao.OrdersDAO;
import com.entity.Orders;
public class OrdersBusiness {
/** Spring IOC DAO 注入 Business * */
private OrdersDAO ordersDAO;
public OrdersDAO getOrdersDAO() { return ordersDAO; }
public void setOrdersDAO(OrdersDAO ordersDAO) { this.ordersDAO = ordersDAO; }
/** save * */
public void save(Orders orders) {this.ordersDAO.save(orders);}
/** update * */
public void update(Orders orders) {this.ordersDAO.update(orders);}
/** delete * */
public void delete(String id) {this.ordersDAO.delete(id);}
/** delete * */
public void delete(int id) {this.ordersDAO.delete(id);}
/** delete * */
public void delete(Orders orders) {this.ordersDAO.delete(orders);}
/** show * */
public List<Orders> show() {return ordersDAO.show();}
/** check * */
public List<Orders> checkOrdercode(String name) {return this.ordersDAO.queryByOrdercode(name);}
/** check * */
public List<Orders> checkUsersid(String name) {return this.ordersDAO.queryByUsersid(name);}
/** check * */
public List<Orders> checkTotal(String name) {return this.ordersDAO.queryByTotal(name);}
/** check * */
public List<Orders> checkStatus(String name) {return this.ordersDAO.queryByStatus(name);}
/** check * */
public List<Orders> checkAddtime(String name) {return this.ordersDAO.queryByAddtime(name);}
/** check * */
public List<Orders> checkReceiver(String name) {return this.ordersDAO.queryByReceiver(name);}
/** check * */
public List<Orders> checkAddress(String name) {return this.ordersDAO.queryByAddress(name);}
/** check * */
public List<Orders> checkContact(String name) {return this.ordersDAO.queryByContact(name);}
/** check * */
public List<Orders> checkByLikeOrdercode(String name) {return this.ordersDAO.queryLikeByOrdercode(name);}
/** check * */
public List<Orders> checkByLikeUsersid(String name) {return this.ordersDAO.queryLikeByUsersid(name);}
/** check * */
public List<Orders> checkByLikeTotal(String name) {return this.ordersDAO.queryLikeByTotal(name);}
/** check * */
public List<Orders> checkByLikeStatus(String name) {return this.ordersDAO.queryLikeByStatus(name);}
/** check * */
public List<Orders> checkByLikeAddtime(String name) {return this.ordersDAO.queryLikeByAddtime(name);}
/** check * */
public List<Orders> checkByLikeReceiver(String name) {return this.ordersDAO.queryLikeByReceiver(name);}
/** check * */
public List<Orders> checkByLikeAddress(String name) {return this.ordersDAO.queryLikeByAddress(name);}
/** check * */
public List<Orders> checkByLikeContact(String name) {return this.ordersDAO.queryLikeByContact(name);}
/** checkId * */
public Orders checkId(String id) {return this.ordersDAO.queryById(id);}

}
