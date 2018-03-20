package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Topic;

public class TopicDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Topic topic) {
		try {
			super.getHibernateTemplate().save(topic);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Topic topic) {
		try {
			super.getHibernateTemplate().update(topic);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Topic topic) {
		try {
			super.getHibernateTemplate().delete(topic);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Topic", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Topic", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Topic> show() {
		try {
			return super.getHibernateTemplate().find("From Topic");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Topic> queryByUsersid(String name) {
		List<Topic> list = new ArrayList<Topic>();
		String hql = "From Topic where usersid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Topic> queryByGoodsid(String name) {
		List<Topic> list = new ArrayList<Topic>();
		String hql = "From Topic where goodsid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Topic> queryByNum(String name) {
		List<Topic> list = new ArrayList<Topic>();
		String hql = "From Topic where num = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Topic> queryByContents(String name) {
		List<Topic> list = new ArrayList<Topic>();
		String hql = "From Topic where contents = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Topic> queryByAddtime(String name) {
		List<Topic> list = new ArrayList<Topic>();
		String hql = "From Topic where addtime = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Topic> queryLikeByUsersid(String name) {
		List<Topic> list = new ArrayList<Topic>();
		String hql = "From Topic where usersid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Topic> queryLikeByGoodsid(String name) {
		List<Topic> list = new ArrayList<Topic>();
		String hql = "From Topic where goodsid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Topic> queryLikeByNum(String name) {
		List<Topic> list = new ArrayList<Topic>();
		String hql = "From Topic where num like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Topic> queryLikeByContents(String name) {
		List<Topic> list = new ArrayList<Topic>();
		String hql = "From Topic where contents like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Topic> queryLikeByAddtime(String name) {
		List<Topic> list = new ArrayList<Topic>();
		String hql = "From Topic where addtime like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Topic queryById(int topicid) {
		try {
			Topic topic = (Topic) super.getHibernateTemplate().get("com.entity.Topic", topicid);
			return topic;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Topic queryById(String topicid) {
		try {
			Topic topic = (Topic) super.getHibernateTemplate().get("com.entity.Topic", topicid);
			return topic;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
