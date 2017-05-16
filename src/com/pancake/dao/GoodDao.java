/**   
 @Title: GoodDao.java 
* @Package com.pancake.dao 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月10日 下午4:53:31 
* @version V1.0   
*/
package com.pancake.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.pancake.entity.Good;
import com.pancake.entity.User;
import com.pancake.util.HibernateSessionFactory;

/**
* @ClassName: GoodDao
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月10日 下午4:53:31
*
*/
public interface GoodDao {
	public List<Good> queryGoodWithPage(int offset, int length, Object user);
	
	public List findByUser(User user);
	
	public List<Good> findAllGoodsWithPage(int offset, int length);
	
	public List findAllByAddTime();

	public void save(Good transientInstance);

	public void delete(Good persistentInstance);

	public Good findById(java.lang.Long id);

	public List findByExample(Good instance);

	public List findByProperty(String propertyName, Object value);

	public List findByName(Object name);

	public List findByPrice(Object price);

	public List findByPictures(Object pictures);
	public List findByFreight(Object freight);

	public List findByDescription(Object description);

	public List findByStatus(Object status);

	public List findAll();

	public Good merge(Good detachedInstance);

	public void attachDirty(Good instance);

	public void attachClean(Good instance);
}
