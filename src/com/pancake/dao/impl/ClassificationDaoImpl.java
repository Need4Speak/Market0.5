package com.pancake.dao.impl;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pancake.dao.ClassificationDao;
import com.pancake.entity.Classification;
import com.pancake.util.HibernateSessionFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classification entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pancake.entity.Classification
 * @author MyEclipse Persistence Tools
 */
public class ClassificationDaoImpl implements ClassificationDao {
	private static final Logger log = LoggerFactory.getLogger(ClassificationDaoImpl.class);
	// property constants
	public static final String CLASSIFICATION_NAME = "classificationName";

	@Override
	public void save(Classification transientInstance) {
		log.debug("saving Classification instance");
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

	@Override
	public void delete(Classification persistentInstance) {
		log.debug("deleting Classification instance");
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

	@Override
	public Classification findById(java.lang.Integer id) {
		log.debug("getting Classification instance with id: " + id);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Classification instance = (Classification) session.get("com.pancake.entity.Classification", id);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(Classification instance) {
		log.debug("finding Classification instance by example");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			List results = session.createCriteria("com.pancake.entity.Classification")
					.add(Example.create(instance)).list();
			transaction.commit();
			HibernateSessionFactory.closeSession();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Classification instance with property: " + propertyName + ", value: " + value);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from Classification as model where model." + propertyName + "= ?";
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

	@Override
	public List findByClassificationName(Object classificationName) {
		return findByProperty(CLASSIFICATION_NAME, classificationName);
	}

	@Override
	public List findAll() {
		log.debug("finding all Classification instances");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from Classification";
			Query queryObject = session.createQuery(queryString);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public Classification merge(Classification detachedInstance) {
		log.debug("merging Classification instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Classification result = (Classification) session.merge(detachedInstance);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(Classification instance) {
		log.debug("attaching dirty Classification instance");
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

	@Override
	public void attachClean(Classification instance) {
		log.debug("attaching clean Classification instance");
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