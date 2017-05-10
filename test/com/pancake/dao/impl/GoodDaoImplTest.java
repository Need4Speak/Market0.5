/**   
* @Title: GoodDaoImplTest.java 
* @Package com.pancake.dao.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月9日 下午3:30:42 
* @version V1.0   
*/
package com.pancake.dao.impl;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import org.junit.Test;

import com.pancake.entity.Classification;
import com.pancake.entity.Good;

/**
* @ClassName: GoodDaoImplTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月9日 下午3:30:42
*
*/
public class GoodDaoImplTest {
	private Good good = null;
	private GoodDaoImpl gdi = new GoodDaoImpl();
	private ClassificationDaoImpl cdi = new ClassificationDaoImpl();
	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#save(com.pancake.entity.Good)}.
	 */
	@Test
	public void testSave() {
		Classification classification = cdi.findById(1);
		good = new Good(classification, "good name", 1.1, "1.jpg",  new Timestamp(System.currentTimeMillis()));
		gdi.save(good);
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#delete(com.pancake.entity.Good)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#findById(java.lang.Long)}.
	 */
	@Test
	public void testFindById() {
		System.out.println(gdi.findById(42l));
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#findByExample(com.pancake.entity.Good)}.
	 */
	@Test
	public void testFindByExample() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#findByProperty(java.lang.String, java.lang.Object)}.
	 */
	@Test
	public void testFindByProperty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#findByName(java.lang.Object)}.
	 */
	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#findByPrice(java.lang.Object)}.
	 */
	@Test
	public void testFindByPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#findByPictures(java.lang.Object)}.
	 */
	@Test
	public void testFindByPictures() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#findByFreight(java.lang.Object)}.
	 */
	@Test
	public void testFindByFreight() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#findByDescription(java.lang.Object)}.
	 */
	@Test
	public void testFindByDescription() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#findByStatus(java.lang.Object)}.
	 */
	@Test
	public void testFindByStatus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#merge(com.pancake.entity.Good)}.
	 */
	@Test
	public void testMerge() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#attachDirty(com.pancake.entity.Good)}.
	 */
	@Test
	public void testAttachDirty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pancake.dao.impl.GoodDaoImpl#attachClean(com.pancake.entity.Good)}.
	 */
	@Test
	public void testAttachClean() {
		fail("Not yet implemented");
	}

}
