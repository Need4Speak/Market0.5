package com.pancake.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pancake.entity.Good;
import com.pancake.util.BaseHibernateDAO;
import com.pancake.util.HibernateSessionFactory;

/**
 * A data access object (DAO) providing persistence and search support for Good
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.pancake.entity.Good
 * @author MyEclipse Persistence Tools
 */
public class GoodDaoImpl extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GoodDaoImpl.class);
	// property constants
	public static final String NAME = "name";
	public static final String PRICE = "price";
	public static final String PICTURES = "pictures";
	public static final String FREIGHT = "freight";
	public static final String DESCRIPTION = "description";
	public static final String STATUS = "status";

	public void save(Good transientInstance) {
		log.debug("saving Good instance");
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

	public void delete(Good persistentInstance) {
		log.debug("deleting Good instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Good findById(java.lang.Long id) {
		log.debug("getting Good instance with id: " + id);
		try {
			Good instance = (Good) getSession().get("com.pancake.entity.Good", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Good instance) {
		log.debug("finding Good instance by example");
		try {
			List results = getSession().createCriteria("com.pancake.entity.Good").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Good instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Good as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByPictures(Object pictures) {
		return findByProperty(PICTURES, pictures);
	}

	public List findByFreight(Object freight) {
		return findByProperty(FREIGHT, freight);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Good instances");
		try {
			String queryString = "from Good";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Good merge(Good detachedInstance) {
		log.debug("merging Good instance");
		try {
			Good result = (Good) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Good instance) {
		log.debug("attaching dirty Good instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Good instance) {
		log.debug("attaching clean Good instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}