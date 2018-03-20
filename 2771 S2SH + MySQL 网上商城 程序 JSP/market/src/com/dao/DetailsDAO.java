package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Details;

public class DetailsDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Details details) {
		try {
			super.getHibernateTemplate().save(details);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Details details) {
		try {
			super.getHibernateTemplate().update(details);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Details details) {
		try {
			super.getHibernateTemplate().delete(details);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Details", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Details", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Details> show() {
		try {
			return super.getHibernateTemplate().find("From Details");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Details> queryByOrdercode(String name) {
		List<Details> list = new ArrayList<Details>();
		String hql = "From Details where ordercode = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Details> queryByGoodsid(String name) {
		List<Details> list = new ArrayList<Details>();
		String hql = "From Details where goodsid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Details> queryByNum(String name) {
		List<Details> list = new ArrayList<Details>();
		String hql = "From Details where num = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Details> queryByPrice(String name) {
		List<Details> list = new ArrayList<Details>();
		String hql = "From Details where price = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Details> queryLikeByOrdercode(String name) {
		List<Details> list = new ArrayList<Details>();
		String hql = "From Details where ordercode like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Details> queryLikeByGoodsid(String name) {
		List<Details> list = new ArrayList<Details>();
		String hql = "From Details where goodsid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Details> queryLikeByNum(String name) {
		List<Details> list = new ArrayList<Details>();
		String hql = "From Details where num like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Details> queryLikeByPrice(String name) {
		List<Details> list = new ArrayList<Details>();
		String hql = "From Details where price like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Details queryById(int detailsid) {
		try {
			Details details = (Details) super.getHibernateTemplate().get("com.entity.Details", detailsid);
			return details;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Details queryById(String detailsid) {
		try {
			Details details = (Details) super.getHibernateTemplate().get("com.entity.Details", detailsid);
			return details;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
