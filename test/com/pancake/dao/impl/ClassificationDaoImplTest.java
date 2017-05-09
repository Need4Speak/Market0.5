/**   
* @Title: ClassificationDaoImplTest.java 
* @Package com.pancake.dao.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月9日 下午3:11:37 
* @version V1.0   
*/
package com.pancake.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pancake.entity.Classification;

/**
* @ClassName: ClassificationDaoImplTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月9日 下午3:11:37
*
*/
public class ClassificationDaoImplTest {
	
	private Classification classification = null;
	private ClassificationDaoImpl cdi = new ClassificationDaoImpl();
	
	/**
	 * Test method for {@link com.pancake.dao.impl.ClassificationDaoImpl#save(com.pancake.entity.Classification)}.
	 */
	@Test
	public void testSave() {
		classification = new Classification("phone");
		cdi.save(classification);
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.ClassificationDaoImpl#delete(com.pancake.entity.Classification)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.ClassificationDaoImpl#findById(java.lang.Integer)}.
	 */
	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.ClassificationDaoImpl#findByExample(com.pancake.entity.Classification)}.
	 */
	@Test
	public void testFindByExample() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.ClassificationDaoImpl#findByProperty(java.lang.String, java.lang.Object)}.
	 */
	@Test
	public void testFindByProperty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.ClassificationDaoImpl#findByClassificationName(java.lang.Object)}.
	 */
	@Test
	public void testFindByClassificationName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.ClassificationDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.ClassificationDaoImpl#merge(com.pancake.entity.Classification)}.
	 */
	@Test
	public void testMerge() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.ClassificationDaoImpl#attachDirty(com.pancake.entity.Classification)}.
	 */
	@Test
	public void testAttachDirty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.ClassificationDaoImpl#attachClean(com.pancake.entity.Classification)}.
	 */
	@Test
	public void testAttachClean() {
		fail("Not yet implemented");
	}

}
