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
import org.springframework.stereotype.Repository;

import com.pancake.dao.GoodDao;
import com.pancake.entity.Good;
import com.pancake.entity.User;
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
@Repository
public class GoodDaoImpl implements GoodDao {
	private static final Logger log = LoggerFactory.getLogger(GoodDaoImpl.class);
	// property constants
	public static final String NAME = "name";
	public static final String PRICE = "price";
	public static final String PICTURES = "pictures";
	public static final String FREIGHT = "freight";
	public static final String DESCRIPTION = "description";
	public static final String STATUS = "status";

	@Override
	public List<Good> queryGoodWithPage(int offset, int length, Object user) {
		List<Good> entitylist = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("from Good where userByOwnerId = ? and status != 0 order by add_time desc");
			query.setParameter(0, user);
			query.setFirstResult(offset);
			query.setMaxResults(length);
			entitylist = query.list();
			transaction.commit();
			HibernateSessionFactory.closeSession();

		} catch (RuntimeException re) {
			throw re;
		}

		return entitylist;
	}

	@Override
	public List findByUser(User user) {
		return findByProperty("userByOwnerId", user);
	}

	@Override
	public List<Good> findAllGoodsWithPage(int offset, int length) {
		List<Good> entitylist = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("from Good where status != 0 order by add_time desc");
			query.setFirstResult(offset);
			query.setMaxResults(length);
			entitylist = query.list();
			transaction.commit();
			HibernateSessionFactory.closeSession();

		} catch (RuntimeException re) {
			throw re;
		}

		return entitylist;
	}
	
    public List findLikeByName(java.lang.String name, int offset, int size) {  
        log.debug("根据商品名称模糊查询商品 " + name);  
        try {  
            name = "'%" + name + "%'";
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(  
                    "from Good where status != 0 and name like " + name + " order by add_time desc");  
            query.setFirstResult(offset);  
            query.setMaxResults(size);  
			List list = query.list();
			transaction.commit();
			HibernateSessionFactory.closeSession();
            return list;  
        } catch (RuntimeException re) {  
            log.error("根据商品名称模糊查询商品出错!", re);  
            throw re;  
        }  
    }  
	
    public List findLikeByNameCount(java.lang.String name) {  
        log.debug("根据商品名称模糊查询商品 " + name);  
        try {  
            name = "'%" + name + "%'";
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(  
                    "from Good where status != 0 and name like " + name + " order by add_time desc");  
			List list = query.list();
			transaction.commit();
			HibernateSessionFactory.closeSession();
            return list;  
        } catch (RuntimeException re) {  
            log.error("根据商品名称模糊查询商品出错!", re);  
            throw re;  
        }  
    }
    
	@Override
	public List findAllByAddTime() {
		//log.debug("finding all Good instances");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from Good order by add_time desc";
			Query queryObject = session.createQuery(queryString);
			List list = queryObject.list();
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return list;
		} catch (RuntimeException re) {
			//log.error("find all failed", re);
			throw re;
		}
	}

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

	public Good findById(java.lang.Long id) {
		log.debug("getting Good instance with id: " + id);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Good instance = (Good) session.get("com.pancake.entity.Good", id);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Good instance) {
		log.debug("finding Good instance by example");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			List results = session.createCriteria("com.pancake.entity.Good").add(Example.create(instance)).list();
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
		log.debug("finding Good instance with property: " + propertyName + ", value: " + value);
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from Good as model where model." + propertyName + "= ?";
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
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			String queryString = "from Good";
			Query queryObject = session.createQuery(queryString);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Good merge(Good detachedInstance) {
		log.debug("merging Good instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Good result = (Good) session.merge(detachedInstance);
			transaction.commit();
			HibernateSessionFactory.closeSession();
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

	public void attachClean(Good instance) {
		log.debug("attaching clean Good instance");
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