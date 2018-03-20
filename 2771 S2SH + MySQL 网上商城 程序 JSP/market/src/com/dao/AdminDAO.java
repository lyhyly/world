package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Admin;

public class AdminDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Admin admin) {
		try {
			super.getHibernateTemplate().save(admin);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Admin admin) {
		try {
			super.getHibernateTemplate().update(admin);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Admin admin) {
		try {
			super.getHibernateTemplate().delete(admin);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Admin", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Admin", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Admin> show() {
		try {
			return super.getHibernateTemplate().find("From Admin");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Admin> queryByUsername(String name) {
		List<Admin> list = new ArrayList<Admin>();
		String hql = "From Admin where username = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Admin> queryByPassword(String name) {
		List<Admin> list = new ArrayList<Admin>();
		String hql = "From Admin where password = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Admin> queryByRealname(String name) {
		List<Admin> list = new ArrayList<Admin>();
		String hql = "From Admin where realname = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Admin> queryByContact(String name) {
		List<Admin> list = new ArrayList<Admin>();
		String hql = "From Admin where contact = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Admin> queryLikeByUsername(String name) {
		List<Admin> list = new ArrayList<Admin>();
		String hql = "From Admin where username like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Admin> queryLikeByPassword(String name) {
		List<Admin> list = new ArrayList<Admin>();
		String hql = "From Admin where password like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Admin> queryLikeByRealname(String name) {
		List<Admin> list = new ArrayList<Admin>();
		String hql = "From Admin where realname like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Admin> queryLikeByContact(String name) {
		List<Admin> list = new ArrayList<Admin>();
		String hql = "From Admin where contact like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Admin queryById(int adminid) {
		try {
			Admin admin = (Admin) super.getHibernateTemplate().get("com.entity.Admin", adminid);
			return admin;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Admin queryById(String adminid) {
		try {
			Admin admin = (Admin) super.getHibernateTemplate().get("com.entity.Admin", adminid);
			return admin;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
