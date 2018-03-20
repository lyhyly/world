package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Scate;

public class ScateDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Scate scate) {
		try {
			super.getHibernateTemplate().save(scate);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Scate scate) {
		try {
			super.getHibernateTemplate().update(scate);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Scate scate) {
		try {
			super.getHibernateTemplate().delete(scate);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Scate", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Scate", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Scate> show() {
		try {
			return super.getHibernateTemplate().find("From Scate");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Scate> queryByBcateid(String name) {
		List<Scate> list = new ArrayList<Scate>();
		String hql = "From Scate where bcateid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Scate> queryByScatename(String name) {
		List<Scate> list = new ArrayList<Scate>();
		String hql = "From Scate where scatename = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Scate> queryLikeByBcateid(String name) {
		List<Scate> list = new ArrayList<Scate>();
		String hql = "From Scate where bcateid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Scate> queryLikeByScatename(String name) {
		List<Scate> list = new ArrayList<Scate>();
		String hql = "From Scate where scatename like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Scate queryById(int scateid) {
		try {
			Scate scate = (Scate) super.getHibernateTemplate().get("com.entity.Scate", scateid);
			return scate;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Scate queryById(String scateid) {
		try {
			Scate scate = (Scate) super.getHibernateTemplate().get("com.entity.Scate", scateid);
			return scate;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
