/**   
* @Title: LeaveWordsServiceImplTest.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月19日 下午8:28:26 
* @version V1.0   
*/
package com.pancake.service.impl;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pancake.entity.LeaveWords;
import com.pancake.service.LeaveWordsService;

/**
* @ClassName: LeaveWordsServiceImplTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月19日 下午8:28:26
*
*/
public class LeaveWordsServiceImplTest {
//	@Autowired 
//	private LeaveWordsService lws;
	private LeaveWordsServiceImpl lwsi = new LeaveWordsServiceImpl();
	@Test
	public void test() {
		Long goodId = 45L;
		List<LeaveWords> list = lwsi.getByGoodId(goodId);
		Iterator<LeaveWords> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getId());
		}
	}

}
