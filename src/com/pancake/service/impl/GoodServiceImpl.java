/**   
* @Title: GoodServiceImpl.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月15日 下午8:04:21 
* @version V1.0   
*/
package com.pancake.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.GoodDaoImpl;
import com.pancake.entity.Classification;
import com.pancake.entity.Good;
import com.pancake.entity.Page;
import com.pancake.service.GoodService;

/**
* @ClassName: GoodServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月15日 下午8:04:21
*
*/
@Service
public class GoodServiceImpl implements GoodService {
	private GoodDaoImpl gdi = new GoodDaoImpl();
	private UserServiceImpl usi = new UserServiceImpl();
	
	
	@Override
	public Page<Good> getAllGoodsWithPage(int currentPage, int pageSize) {
		Page<Good> page = new Page<Good>();
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Good> list = gdi.findAllGoodsWithPage(offset, pageSize);
		// 总记录数
		ArrayList<Good> goodsList = null;
		goodsList = (ArrayList<Good>) gdi.findAllByAddTime();

		// Remove good in goodsList whose status is 0. 0 means this good can not
		// buy.
		Iterator<Good> iter = goodsList.iterator();
		while (iter.hasNext()) {
			Good good = iter.next();
			if (0 == good.getStatus()) {
				iter.remove();
			}
		}
		int allRow = goodsList.size();

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}


	@Override
	public Page<Good> getUserGoodsWithPage(int currentPage, int pageSize, int classificationId, String userName) {
		Page<Good> page = new Page<Good>();
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		
		// 分页查询结果集
		List<Good> list = gdi.queryGoodWithPage(offset, pageSize, usi.getByName(userName));
		// 总记录数
		ArrayList<Good> goodsList = (ArrayList<Good>) gdi.findByUser(usi.getByName(userName));
//		ArrayList<Good> goodsList = null;
////		int classificationId = -1;
//		if (classificationId == -1) {
//			goodsList = (ArrayList<Good>) gdi.findAllByAddTime();
//		} else {
//			Classification classification = cdi.findById(classificationId);
//			goodsList = (ArrayList<Good>) gdi.findByClassification(classification);
//		}

		// Remove good in goodsList whose status is 0. 0 means this good can not
		// buy.
		Iterator<Good> iter = goodsList.iterator();
		while (iter.hasNext()) {
			Good good = iter.next();
			if (0 == good.getStatus()) {
				iter.remove();
			}
		}
		int allRow = goodsList.size();

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}


	@Override
	public Good getById(Long id) {
		return gdi.findById(id);
	}

}
