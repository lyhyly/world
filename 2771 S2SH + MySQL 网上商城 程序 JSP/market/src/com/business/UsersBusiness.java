package com.business;
import java.util.List;
import com.dao.UsersDAO;
import com.entity.Users;
public class UsersBusiness {
/** Spring IOC DAO 注入 Business * */
private UsersDAO usersDAO;
public UsersDAO getUsersDAO() { return usersDAO; }
public void setUsersDAO(UsersDAO usersDAO) { this.usersDAO = usersDAO; }
/** save * */
public void save(Users users) {this.usersDAO.save(users);}
/** update * */
public void update(Users users) {this.usersDAO.update(users);}
/** delete * */
public void delete(String id) {this.usersDAO.delete(id);}
/** delete * */
public void delete(int id) {this.usersDAO.delete(id);}
/** delete * */
public void delete(Users users) {this.usersDAO.delete(users);}
/** show * */
public List<Users> show() {return usersDAO.show();}
/** check * */
public List<Users> checkUsername(String name) {return this.usersDAO.queryByUsername(name);}
/** check * */
public List<Users> checkPassword(String name) {return this.usersDAO.queryByPassword(name);}
/** check * */
public List<Users> checkRealname(String name) {return this.usersDAO.queryByRealname(name);}
/** check * */
public List<Users> checkSex(String name) {return this.usersDAO.queryBySex(name);}
/** check * */
public List<Users> checkBirthday(String name) {return this.usersDAO.queryByBirthday(name);}
/** check * */
public List<Users> checkContact(String name) {return this.usersDAO.queryByContact(name);}
/** check * */
public List<Users> checkRegdate(String name) {return this.usersDAO.queryByRegdate(name);}
/** check * */
public List<Users> checkByLikeUsername(String name) {return this.usersDAO.queryLikeByUsername(name);}
/** check * */
public List<Users> checkByLikePassword(String name) {return this.usersDAO.queryLikeByPassword(name);}
/** check * */
public List<Users> checkByLikeRealname(String name) {return this.usersDAO.queryLikeByRealname(name);}
/** check * */
public List<Users> checkByLikeSex(String name) {return this.usersDAO.queryLikeBySex(name);}
/** check * */
public List<Users> checkByLikeBirthday(String name) {return this.usersDAO.queryLikeByBirthday(name);}
/** check * */
public List<Users> checkByLikeContact(String name) {return this.usersDAO.queryLikeByContact(name);}
/** check * */
public List<Users> checkByLikeRegdate(String name) {return this.usersDAO.queryLikeByRegdate(name);}
/** checkId * */
public Users checkId(String id) {return this.usersDAO.queryById(id);}

}
