/**   
* @Title: ClassificationDao.java 
* @Package com.pancake.dao 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月9日 下午2:52:46 
* @version V1.0   
*/
package com.pancake.dao;

import java.util.List;

import com.pancake.entity.Classification;

/**
 * @InterfaceName: ClassificationDao
 * @Description: TODO
 * @author chao zcsd2668@163.com
 * @date 2017年5月9日 下午2:52:46
 *
 */
public interface ClassificationDao {
	public void save(Classification transientInstance);

	public void delete(Classification persistentInstance);

	public Classification findById(java.lang.Integer id);

	public List findByExample(Classification instance);

	public List findByProperty(String propertyName, Object value);

	public List findByClassificationName(Object classificationName);

	public List findAll();

	public Classification merge(Classification detachedInstance);

	public void attachDirty(Classification instance);

	public void attachClean(Classification instance);

}
