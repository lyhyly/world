package com.business;
import java.util.List;
import com.dao.ArticleDAO;
import com.entity.Article;
public class ArticleBusiness {
/** Spring IOC DAO 注入 Business * */
private ArticleDAO articleDAO;
public ArticleDAO getArticleDAO() { return articleDAO; }
public void setArticleDAO(ArticleDAO articleDAO) { this.articleDAO = articleDAO; }
/** save * */
public void save(Article article) {this.articleDAO.save(article);}
/** update * */
public void update(Article article) {this.articleDAO.update(article);}
/** delete * */
public void delete(String id) {this.articleDAO.delete(id);}
/** delete * */
public void delete(int id) {this.articleDAO.delete(id);}
/** delete * */
public void delete(Article article) {this.articleDAO.delete(article);}
/** show * */
public List<Article> show() {return articleDAO.show();}
/** check * */
public List<Article> checkTitle(String name) {return this.articleDAO.queryByTitle(name);}
/** check * */
public List<Article> checkImage(String name) {return this.articleDAO.queryByImage(name);}
/** check * */
public List<Article> checkContents(String name) {return this.articleDAO.queryByContents(name);}
/** check * */
public List<Article> checkAddtime(String name) {return this.articleDAO.queryByAddtime(name);}
/** check * */
public List<Article> checkHits(String name) {return this.articleDAO.queryByHits(name);}
/** check * */
public List<Article> checkByLikeTitle(String name) {return this.articleDAO.queryLikeByTitle(name);}
/** check * */
public List<Article> checkByLikeImage(String name) {return this.articleDAO.queryLikeByImage(name);}
/** check * */
public List<Article> checkByLikeContents(String name) {return this.articleDAO.queryLikeByContents(name);}
/** check * */
public List<Article> checkByLikeAddtime(String name) {return this.articleDAO.queryLikeByAddtime(name);}
/** check * */
public List<Article> checkByLikeHits(String name) {return this.articleDAO.queryLikeByHits(name);}
/** checkId * */
public Article checkId(String id) {return this.articleDAO.queryById(id);}

}
