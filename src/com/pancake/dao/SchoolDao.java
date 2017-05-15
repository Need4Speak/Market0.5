/**   
* @Title: SchoolDao.java 
* @Package com.pancake.dao 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月15日 下午4:20:55 
* @version V1.0   
*/
package com.pancake.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.pancake.entity.School;

/**
* @ClassName: SchoolDao
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月15日 下午4:20:55
*
*/
public interface SchoolDao {
	public void save(School transientInstance);

	public void delete(School persistentInstance);

	public School findById(java.lang.Integer id);

	public List findByExample(School instance);

	public List findByProperty(String propertyName, Object value);

	public List findBySchoolName(Object schoolName);

	public List findAll();

	public School merge(School detachedInstance);

	public void attachDirty(School instance);

	public void attachClean(School instance);
}
