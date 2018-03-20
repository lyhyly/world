package com.business;
import java.util.List;
import com.dao.DetailsDAO;
import com.entity.Details;
public class DetailsBusiness {
/** Spring IOC DAO 注入 Business * */
private DetailsDAO detailsDAO;
public DetailsDAO getDetailsDAO() { return detailsDAO; }
public void setDetailsDAO(DetailsDAO detailsDAO) { this.detailsDAO = detailsDAO; }
/** save * */
public void save(Details details) {this.detailsDAO.save(details);}
/** update * */
public void update(Details details) {this.detailsDAO.update(details);}
/** delete * */
public void delete(String id) {this.detailsDAO.delete(id);}
/** delete * */
public void delete(int id) {this.detailsDAO.delete(id);}
/** delete * */
public void delete(Details details) {this.detailsDAO.delete(details);}
/** show * */
public List<Details> show() {return detailsDAO.show();}
/** check * */
public List<Details> checkOrdercode(String name) {return this.detailsDAO.queryByOrdercode(name);}
/** check * */
public List<Details> checkGoodsid(String name) {return this.detailsDAO.queryByGoodsid(name);}
/** check * */
public List<Details> checkNum(String name) {return this.detailsDAO.queryByNum(name);}
/** check * */
public List<Details> checkPrice(String name) {return this.detailsDAO.queryByPrice(name);}
/** check * */
public List<Details> checkByLikeOrdercode(String name) {return this.detailsDAO.queryLikeByOrdercode(name);}
/** check * */
public List<Details> checkByLikeGoodsid(String name) {return this.detailsDAO.queryLikeByGoodsid(name);}
/** check * */
public List<Details> checkByLikeNum(String name) {return this.detailsDAO.queryLikeByNum(name);}
/** check * */
public List<Details> checkByLikePrice(String name) {return this.detailsDAO.queryLikeByPrice(name);}
/** checkId * */
public Details checkId(String id) {return this.detailsDAO.queryById(id);}

}
