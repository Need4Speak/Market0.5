/**   
* @Title: CollectionDaoImplTest.java 
* @Package com.pancake.dao.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月10日 下午4:33:45 
* @version V1.0   
*/
package com.pancake.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

/**
* @ClassName: CollectionDaoImplTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月10日 下午4:33:45
*
*/
public class CollectionDaoImplTest {
	
	private FavoriteDaoImpl cdi = new FavoriteDaoImpl();
	
	/**
	 * Test method for {@link com.pancake.dao.impl.FavoriteDaoImpl#save(com.pancake.entity.Collection)}.
	 */
	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.FavoriteDaoImpl#delete(com.pancake.entity.Collection)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.FavoriteDaoImpl#findById(java.lang.Long)}.
	 */
	@Test
	public void testFindById() {
		System.out.println(cdi.findById(20l));
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.FavoriteDaoImpl#findByExample(com.pancake.entity.Collection)}.
	 */
	@Test
	public void testFindByExample() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.FavoriteDaoImpl#findByProperty(java.lang.String, java.lang.Object)}.
	 */
	@Test
	public void testFindByProperty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.FavoriteDaoImpl#findByDescription(java.lang.Object)}.
	 */
	@Test
	public void testFindByDescription() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.FavoriteDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.FavoriteDaoImpl#merge(com.pancake.entity.Collection)}.
	 */
	@Test
	public void testMerge() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.FavoriteDaoImpl#attachDirty(com.pancake.entity.Collection)}.
	 */
	@Test
	public void testAttachDirty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.FavoriteDaoImpl#attachClean(com.pancake.entity.Collection)}.
	 */
	@Test
	public void testAttachClean() {
		fail("Not yet implemented");
	}

}
