/**   
* @Title: LeaveWordsDaoImpl.java 
* @Package com.pancake.dao 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月15日 下午4:14:53 
* @version V1.0   
*/
package com.pancake.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.pancake.entity.LeaveWords;

/**
 * @ClassName: LeaveWordsDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chao zcsd2668@163.com
 * @date 2017年5月15日 下午4:14:53
 *
 */
public interface LeaveWordsDao {
	public void save(LeaveWords transientInstance);

	public void delete(LeaveWords persistentInstance);

	public LeaveWords findById(java.lang.Integer id);

	public List findByExample(LeaveWords instance);

	public List findByProperty(String propertyName, Object value);

	public List findByContent(Object content);

	public List findAll();

	public LeaveWords merge(LeaveWords detachedInstance);

	public void attachDirty(LeaveWords instance);

	public void attachClean(LeaveWords instance);
}
