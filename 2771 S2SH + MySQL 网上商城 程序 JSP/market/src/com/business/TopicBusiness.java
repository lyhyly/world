package com.business;
import java.util.List;
import com.dao.TopicDAO;
import com.entity.Topic;
public class TopicBusiness {
/** Spring IOC DAO 注入 Business * */
private TopicDAO topicDAO;
public TopicDAO getTopicDAO() { return topicDAO; }
public void setTopicDAO(TopicDAO topicDAO) { this.topicDAO = topicDAO; }
/** save * */
public void save(Topic topic) {this.topicDAO.save(topic);}
/** update * */
public void update(Topic topic) {this.topicDAO.update(topic);}
/** delete * */
public void delete(String id) {this.topicDAO.delete(id);}
/** delete * */
public void delete(int id) {this.topicDAO.delete(id);}
/** delete * */
public void delete(Topic topic) {this.topicDAO.delete(topic);}
/** show * */
public List<Topic> show() {return topicDAO.show();}
/** check * */
public List<Topic> checkUsersid(String name) {return this.topicDAO.queryByUsersid(name);}
/** check * */
public List<Topic> checkGoodsid(String name) {return this.topicDAO.queryByGoodsid(name);}
/** check * */
public List<Topic> checkNum(String name) {return this.topicDAO.queryByNum(name);}
/** check * */
public List<Topic> checkContents(String name) {return this.topicDAO.queryByContents(name);}
/** check * */
public List<Topic> checkAddtime(String name) {return this.topicDAO.queryByAddtime(name);}
/** check * */
public List<Topic> checkByLikeUsersid(String name) {return this.topicDAO.queryLikeByUsersid(name);}
/** check * */
public List<Topic> checkByLikeGoodsid(String name) {return this.topicDAO.queryLikeByGoodsid(name);}
/** check * */
public List<Topic> checkByLikeNum(String name) {return this.topicDAO.queryLikeByNum(name);}
/** check * */
public List<Topic> checkByLikeContents(String name) {return this.topicDAO.queryLikeByContents(name);}
/** check * */
public List<Topic> checkByLikeAddtime(String name) {return this.topicDAO.queryLikeByAddtime(name);}
/** checkId * */
public Topic checkId(String id) {return this.topicDAO.queryById(id);}

}
