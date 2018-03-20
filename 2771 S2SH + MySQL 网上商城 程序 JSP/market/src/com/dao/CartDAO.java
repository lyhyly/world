package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Cart;

public class CartDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Cart cart) {
		try {
			super.getHibernateTemplate().save(cart);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Cart cart) {
		try {
			super.getHibernateTemplate().update(cart);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Cart cart) {
		try {
			super.getHibernateTemplate().delete(cart);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Cart", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Cart", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Cart> show() {
		try {
			return super.getHibernateTemplate().find("From Cart");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Cart> queryByUsersid(String name) {
		List<Cart> list = new ArrayList<Cart>();
		String hql = "From Cart where usersid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Cart> queryByGoodsid(String name) {
		List<Cart> list = new ArrayList<Cart>();
		String hql = "From Cart where goodsid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Cart> queryByNum(String name) {
		List<Cart> list = new ArrayList<Cart>();
		String hql = "From Cart where num = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Cart> queryByPrice(String name) {
		List<Cart> list = new ArrayList<Cart>();
		String hql = "From Cart where price = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Cart> queryByAddtime(String name) {
		List<Cart> list = new ArrayList<Cart>();
		String hql = "From Cart where addtime = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Cart> queryLikeByUsersid(String name) {
		List<Cart> list = new ArrayList<Cart>();
		String hql = "From Cart where usersid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Cart> queryLikeByGoodsid(String name) {
		List<Cart> list = new ArrayList<Cart>();
		String hql = "From Cart where goodsid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Cart> queryLikeByNum(String name) {
		List<Cart> list = new ArrayList<Cart>();
		String hql = "From Cart where num like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Cart> queryLikeByPrice(String name) {
		List<Cart> list = new ArrayList<Cart>();
		String hql = "From Cart where price like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Cart> queryLikeByAddtime(String name) {
		List<Cart> list = new ArrayList<Cart>();
		String hql = "From Cart where addtime like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Cart queryById(int cartid) {
		try {
			Cart cart = (Cart) super.getHibernateTemplate().get("com.entity.Cart", cartid);
			return cart;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Cart queryById(String cartid) {
		try {
			Cart cart = (Cart) super.getHibernateTemplate().get("com.entity.Cart", cartid);
			return cart;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
