package com.business;
import java.util.List;
import com.dao.ScateDAO;
import com.entity.Scate;
public class ScateBusiness {
/** Spring IOC DAO 注入 Business * */
private ScateDAO scateDAO;
public ScateDAO getScateDAO() { return scateDAO; }
public void setScateDAO(ScateDAO scateDAO) { this.scateDAO = scateDAO; }
/** save * */
public void save(Scate scate) {this.scateDAO.save(scate);}
/** update * */
public void update(Scate scate) {this.scateDAO.update(scate);}
/** delete * */
public void delete(String id) {this.scateDAO.delete(id);}
/** delete * */
public void delete(int id) {this.scateDAO.delete(id);}
/** delete * */
public void delete(Scate scate) {this.scateDAO.delete(scate);}
/** show * */
public List<Scate> show() {return scateDAO.show();}
/** check * */
public List<Scate> checkBcateid(String name) {return this.scateDAO.queryByBcateid(name);}
/** check * */
public List<Scate> checkScatename(String name) {return this.scateDAO.queryByScatename(name);}
/** check * */
public List<Scate> checkByLikeBcateid(String name) {return this.scateDAO.queryLikeByBcateid(name);}
/** check * */
public List<Scate> checkByLikeScatename(String name) {return this.scateDAO.queryLikeByScatename(name);}
/** checkId * */
public Scate checkId(String id) {return this.scateDAO.queryById(id);}

}
