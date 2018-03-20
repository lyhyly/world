package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Goods;

public class GoodsDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Goods goods) {
		try {
			super.getHibernateTemplate().save(goods);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Goods goods) {
		try {
			super.getHibernateTemplate().update(goods);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Goods goods) {
		try {
			super.getHibernateTemplate().delete(goods);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Goods", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Goods", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Goods> show() {
		try {
			return super.getHibernateTemplate().find("From Goods");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Goods> hot() {
		List<Goods> list = new ArrayList<Goods>();
		Session session = this.getSessionFactory().openSession();
		String hql = "From Goods order by hits desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(5);
		list = query.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Goods> front(String name) {
		List<Goods> list = new ArrayList<Goods>();
		Session session = this.getSessionFactory().openSession();
		String hql = "From Goods where bcateid = ? order by sellnum desc";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		query.setFirstResult(0);
		query.setMaxResults(5);
		list = query.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Goods> recommend() {
		List<Goods> list = new ArrayList<Goods>();
		Session session = this.getSessionFactory().openSession();
		String hql = "From Goods where recommend = '是'";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(4);
		list = query.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Goods> special() {
		List<Goods> list = new ArrayList<Goods>();
		Session session = this.getSessionFactory().openSession();
		String hql = "From Goods where special = '是'";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(10);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByGoodsname(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where goodsname = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByImage(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where image = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByBcateid(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where bcateid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByScateid(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where scateid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByMarketprice(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where marketprice = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByPrice(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where price = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByRecommend(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where recommend = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryBySpecial(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where special = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByStorage(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where storage = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByAddtime(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where addtime = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryBySellnum(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where sellnum = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByHits(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where hits = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Goods> queryByContents(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where contents = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByGoodsname(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where goodsname like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByImage(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where image like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByBcateid(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where bcateid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByScateid(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where scateid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByMarketprice(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where marketprice like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByPrice(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where price like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByRecommend(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where recommend like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeBySpecial(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where special like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByStorage(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where storage like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByAddtime(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where addtime like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeBySellnum(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where sellnum like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByHits(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where hits like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Goods> queryLikeByContents(String name) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = "From Goods where contents like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Goods queryById(int goodsid) {
		try {
			Goods goods = (Goods) super.getHibernateTemplate().get("com.entity.Goods", goodsid);
			return goods;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Goods queryById(String goodsid) {
		try {
			Goods goods = (Goods) super.getHibernateTemplate().get("com.entity.Goods", goodsid);
			return goods;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
