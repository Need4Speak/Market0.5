/**   
* @Title: ClassificationServiceImpl.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月17日 下午3:18:02 
* @version V1.0   
*/
package com.pancake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pancake.dao.ClassificationDao;
import com.pancake.entity.Classification;
import com.pancake.service.ClassificationService;

/**
* @ClassName: ClassificationServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月17日 下午3:18:02
*
*/
@Service
public class ClassificationServiceImpl implements ClassificationService {
	@Autowired
	private ClassificationDao cd;
	
	@Override
	public List<Classification> getAllClassifications() {
		return cd.findAll();
	}

	@Override
	public Classification getClassificationById(int id) {
		return cd.findById(id);
	}

}
