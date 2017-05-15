/**   
* @Title: UserDao.java 
* @Package com.pancake.dao 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月15日 下午4:57:29 
* @version V1.0   
*/
package com.pancake.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.pancake.entity.User;

/**
* @ClassName: UserDao
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月15日 下午4:57:29
*
*/
public interface UserDao {
	public void save(User transientInstance);

	public void delete(User persistentInstance);

	public User findById(java.lang.Long id);

	public List findByExample(User instance);

	public List findByProperty(String propertyName, Object value);

	public List findByUserName(Object userName);

	public List findByPassword(Object password);

	public List findByPhone(Object phone);

	public List findByWechat(Object wechat);

	public List findByEmail(Object email);

	public List findByGender(Object gender);

	public List findByUserPhoto(Object userPhoto);
	public List findByUserAddress(Object userAddress);

	public List findAll();

	public User merge(User detachedInstance);

	public void attachDirty(User instance);

	public void attachClean(User instance);
}
