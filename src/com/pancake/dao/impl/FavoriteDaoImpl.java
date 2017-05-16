package com.pancake.dao.impl;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pancake.dao.FavoriteDao;
import com.pancake.entity.Favorite;
import com.pancake.util.HibernateSessionFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Favorite entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.pancake.entity.Favorite
 * @author MyEclipse Persistence Tools
 */
public class FavoriteDaoImpl implements FavoriteDao {
	private static final Logger log = LoggerFactory.getLogger(FavoriteDaoImpl.class);
	// property constants
	public static final String DESCRIPTION = "description";

	@Override
	public List findByBuyer(Object buyer) {
		return findByProperty("userByBuyerId", buyer);
	}
	
	public void save(Favorite transientInstance) {
		log.debug("saving Favorite instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(transientInstance);	
			transaction.commit();
			HibernateSessionFactory.closeSession();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Favorite persistentInstance) {
		log.debug("deleting Favorite instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(persistentInstance);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Favorite findById(java.lang.Long id) {
		log.debug("getting Favorite instance with id: " + id);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Favorite instance = (Favorite) session.get("com.pancake.entity.Favorite", id);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Favorite instance) {
		log.debug("finding Favorite instance by example");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			List results = session.createCriteria("com.pancake.entity.Favorite").add(Example.create(instance))
					.list();
			transaction.commit();
			HibernateSessionFactory.closeSession();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Favorite instance with property: " + propertyName + ", value: " + value);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from Favorite as model where model." + propertyName + "= ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Favorite instances");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from Favorite";
			Query queryObject = session.createQuery(queryString);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Favorite merge(Favorite detachedInstance) {
		log.debug("merging Favorite instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Favorite result = (Favorite) session.merge(detachedInstance);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Favorite instance) {
		log.debug("attaching dirty Favorite instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(instance);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Favorite instance) {
		log.debug("attaching clean Favorite instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.buildLockRequest(LockOptions.NONE).lock(instance);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}