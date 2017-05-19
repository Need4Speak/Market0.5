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
import org.springframework.stereotype.Repository;

import com.pancake.dao.UserDao;
import com.pancake.entity.User;
import com.pancake.util.BaseHibernateDAO;
import com.pancake.util.HibernateSessionFactory;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.pancake.entity.User
 * @author MyEclipse Persistence Tools
 */
@Repository
public class UserDaoImpl implements UserDao {
	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String PHONE = "phone";
	public static final String WECHAT = "wechat";
	public static final String EMAIL = "email";
	public static final String GENDER = "gender";
	public static final String USER_PHOTO = "userPhoto";
	public static final String USER_ADDRESS = "userAddress";

	@Override
	public void save(User transientInstance) {
		log.debug("saving User instance");
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
	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
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
	public User findById(java.lang.Long id) {
		log.debug("getting User instance with id: " + id);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			User instance = (User) session.get("com.pancake.entity.User", id);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			List results = session.createCriteria("com.pancake.entity.User").add(Example.create(instance)).list();
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
		log.debug("finding User instance with property: " + propertyName + ", value: " + value);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from User as model where model." + propertyName + "= ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			List list = queryObject.list();
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return list;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	@Override
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	@Override
	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	@Override
	public List findByWechat(Object wechat) {
		return findByProperty(WECHAT, wechat);
	}

	@Override
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	@Override
	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	@Override
	public List findByUserPhoto(Object userPhoto) {
		return findByProperty(USER_PHOTO, userPhoto);
	}

	@Override
	public List findByUserAddress(Object userAddress) {
		return findByProperty(USER_ADDRESS, userAddress);
	}

	@Override
	public List findAll() {
		log.debug("finding all User instances");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from User";
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
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			User result = (User) session.merge(detachedInstance);
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
	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
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
	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
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