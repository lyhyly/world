package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Orders;

public class OrdersDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Orders orders) {
		try {
			super.getHibernateTemplate().save(orders);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Orders orders) {
		try {
			super.getHibernateTemplate().update(orders);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Orders orders) {
		try {
			super.getHibernateTemplate().delete(orders);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Orders", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Orders", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Orders> show() {
		try {
			return super.getHibernateTemplate().find("From Orders");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Orders> queryByOrdercode(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where ordercode = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Orders> queryByUsersid(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where usersid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Orders> queryByTotal(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where total = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Orders> queryByStatus(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where status = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Orders> queryByAddtime(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where addtime = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Orders> queryByReceiver(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where receiver = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Orders> queryByAddress(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where address = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Orders> queryByContact(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where contact = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Orders> queryLikeByOrdercode(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where ordercode like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Orders> queryLikeByUsersid(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where usersid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Orders> queryLikeByTotal(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where total like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Orders> queryLikeByStatus(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where status like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Orders> queryLikeByAddtime(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where addtime like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Orders> queryLikeByReceiver(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where receiver like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Orders> queryLikeByAddress(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where address like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Orders> queryLikeByContact(String name) {
		List<Orders> list = new ArrayList<Orders>();
		String hql = "From Orders where contact like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Orders queryById(int ordersid) {
		try {
			Orders orders = (Orders) super.getHibernateTemplate().get("com.entity.Orders", ordersid);
			return orders;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Orders queryById(String ordersid) {
		try {
			Orders orders = (Orders) super.getHibernateTemplate().get("com.entity.Orders", ordersid);
			return orders;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
