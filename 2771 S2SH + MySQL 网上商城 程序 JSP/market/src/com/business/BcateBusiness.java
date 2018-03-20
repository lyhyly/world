package com.business;
import java.util.List;
import com.dao.BcateDAO;
import com.entity.Bcate;
public class BcateBusiness {
/** Spring IOC DAO 注入 Business * */
private BcateDAO bcateDAO;
public BcateDAO getBcateDAO() { return bcateDAO; }
public void setBcateDAO(BcateDAO bcateDAO) { this.bcateDAO = bcateDAO; }
/** save * */
public void save(Bcate bcate) {this.bcateDAO.save(bcate);}
/** update * */
public void update(Bcate bcate) {this.bcateDAO.update(bcate);}
/** delete * */
public void delete(String id) {this.bcateDAO.delete(id);}
/** delete * */
public void delete(int id) {this.bcateDAO.delete(id);}
/** delete * */
public void delete(Bcate bcate) {this.bcateDAO.delete(bcate);}
/** show * */
public List<Bcate> show() {return bcateDAO.show();}
public List<Bcate> front() {return bcateDAO.front();}
/** check * */
public List<Bcate> checkBcatename(String name) {return this.bcateDAO.queryByBcatename(name);}
/** check * */
public List<Bcate> checkByLikeBcatename(String name) {return this.bcateDAO.queryLikeByBcatename(name);}
/** checkId * */
public Bcate checkId(String id) {return this.bcateDAO.queryById(id);}

}
