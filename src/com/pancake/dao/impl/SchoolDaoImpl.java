package com.pancake.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pancake.dao.SchoolDao;
import com.pancake.entity.School;
import com.pancake.util.BaseHibernateDAO;
import com.pancake.util.HibernateSessionFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * School entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.pancake.entity.School
 * @author MyEclipse Persistence Tools
 */
public class SchoolDaoImpl implements SchoolDao {
	private static final Logger log = LoggerFactory.getLogger(SchoolDaoImpl.class);
	// property constants
	public static final String SCHOOL_NAME = "schoolName";
	
	@Override
	public void save(School transientInstance) {
		log.debug("saving School instance");
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
	public void delete(School persistentInstance) {
		log.debug("deleting School instance");
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
	public School findById(java.lang.Integer id) {
		log.debug("getting School instance with id: " + id);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			School instance = (School) session.get("com.pancake.entity.School", id);
			transaction.commit();
			HibernateSessionFactory.closeSession();

			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(School instance) {
		log.debug("finding School instance by example");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			List results = session.createCriteria("com.pancake.entity.School").add(Example.create(instance)).list();
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
		log.debug("finding School instance with property: " + propertyName + ", value: " + value);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from School as model where model." + propertyName + "= ?";
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
	public List findBySchoolName(Object schoolName) {
		return findByProperty(SCHOOL_NAME, schoolName);
	}

	@Override
	public List findAll() {
		log.debug("finding all School instances");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from School";
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
	public School merge(School detachedInstance) {
		log.debug("merging School instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			School result = (School) session.merge(detachedInstance);
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
	public void attachDirty(School instance) {
		log.debug("attaching dirty School instance");
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
	public void attachClean(School instance) {
		log.debug("attaching clean School instance");
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