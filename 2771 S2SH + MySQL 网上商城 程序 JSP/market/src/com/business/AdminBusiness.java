package com.business;
import java.util.List;
import com.dao.AdminDAO;
import com.entity.Admin;
public class AdminBusiness {
/** Spring IOC DAO 注入 Business * */
private AdminDAO adminDAO;
public AdminDAO getAdminDAO() { return adminDAO; }
public void setAdminDAO(AdminDAO adminDAO) { this.adminDAO = adminDAO; }
/** save * */
public void save(Admin admin) {this.adminDAO.save(admin);}
/** update * */
public void update(Admin admin) {this.adminDAO.update(admin);}
/** delete * */
public void delete(String id) {this.adminDAO.delete(id);}
/** delete * */
public void delete(int id) {this.adminDAO.delete(id);}
/** delete * */
public void delete(Admin admin) {this.adminDAO.delete(admin);}
/** show * */
public List<Admin> show() {return adminDAO.show();}
/** check * */
public List<Admin> checkUsername(String name) {return this.adminDAO.queryByUsername(name);}
/** check * */
public List<Admin> checkPassword(String name) {return this.adminDAO.queryByPassword(name);}
/** check * */
public List<Admin> checkRealname(String name) {return this.adminDAO.queryByRealname(name);}
/** check * */
public List<Admin> checkContact(String name) {return this.adminDAO.queryByContact(name);}
/** check * */
public List<Admin> checkByLikeUsername(String name) {return this.adminDAO.queryLikeByUsername(name);}
/** check * */
public List<Admin> checkByLikePassword(String name) {return this.adminDAO.queryLikeByPassword(name);}
/** check * */
public List<Admin> checkByLikeRealname(String name) {return this.adminDAO.queryLikeByRealname(name);}
/** check * */
public List<Admin> checkByLikeContact(String name) {return this.adminDAO.queryLikeByContact(name);}
/** checkId * */
public Admin checkId(String id) {return this.adminDAO.queryById(id);}

}
