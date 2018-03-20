package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Bcate;

public class BcateDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Bcate bcate) {
		try {
			super.getHibernateTemplate().save(bcate);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Bcate bcate) {
		try {
			super.getHibernateTemplate().update(bcate);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Bcate bcate) {
		try {
			super.getHibernateTemplate().delete(bcate);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Bcate", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Bcate", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Bcate> show() {
		try {
			return super.getHibernateTemplate().find("From Bcate");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Bcate> front() {
		List<Bcate> list = new ArrayList<Bcate>();
		String hql = "From Bcate";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(4);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Bcate> queryByBcatename(String name) {
		List<Bcate> list = new ArrayList<Bcate>();
		String hql = "From Bcate where bcatename = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Bcate> queryLikeByBcatename(String name) {
		List<Bcate> list = new ArrayList<Bcate>();
		String hql = "From Bcate where bcatename like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Bcate queryById(int bcateid) {
		try {
			Bcate bcate = (Bcate) super.getHibernateTemplate().get("com.entity.Bcate", bcateid);
			return bcate;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Bcate queryById(String bcateid) {
		try {
			Bcate bcate = (Bcate) super.getHibernateTemplate().get("com.entity.Bcate", bcateid);
			return bcate;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
