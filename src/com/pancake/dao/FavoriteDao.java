/**   
* @Title: CollectionDao.java 
* @Package com.pancake.dao 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月10日 下午4:27:52 
* @version V1.0   
*/
package com.pancake.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.pancake.entity.Favorite;

/**
 * @ClassName: CollectionDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chao zcsd2668@163.com
 * @date 2017年5月10日 下午4:27:52
 *
 */
public interface FavoriteDao {
	public void save(Favorite transientInstance);

	public void delete(Favorite persistentInstance);

	public Favorite findById(java.lang.Long id);

	public List findByExample(Favorite instance);

	public List findByProperty(String propertyName, Object value);

	public List findByDescription(Object description);

	public List findAll();

	public Favorite merge(Favorite detachedInstance);

	public void attachDirty(Favorite instance);

	public void attachClean(Favorite instance);
}
