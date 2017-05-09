package com.pancake.dao.impl;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pancake.entity.LeaveWords;
import com.pancake.util.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * LeaveWords entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.pancake.entity.LeaveWords
 * @author MyEclipse Persistence Tools
 */
public class LeaveWordsDaoImpl extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LeaveWordsDaoImpl.class);
	// property constants
	public static final String CONTENT = "content";

	public void save(LeaveWords transientInstance) {
		log.debug("saving LeaveWords instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LeaveWords persistentInstance) {
		log.debug("deleting LeaveWords instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LeaveWords findById(java.lang.Integer id) {
		log.debug("getting LeaveWords instance with id: " + id);
		try {
			LeaveWords instance = (LeaveWords) getSession().get("com.pancake.entity.LeaveWords", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LeaveWords instance) {
		log.debug("finding LeaveWords instance by example");
		try {
			List results = getSession().createCriteria("com.pancake.entity.LeaveWords").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding LeaveWords instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from LeaveWords as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all LeaveWords instances");
		try {
			String queryString = "from LeaveWords";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LeaveWords merge(LeaveWords detachedInstance) {
		log.debug("merging LeaveWords instance");
		try {
			LeaveWords result = (LeaveWords) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LeaveWords instance) {
		log.debug("attaching dirty LeaveWords instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LeaveWords instance) {
		log.debug("attaching clean LeaveWords instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}