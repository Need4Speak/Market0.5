/**   
* @Title: ClassificationService.java 
* @Package com.pancake.service 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月17日 下午3:16:49 
* @version V1.0   
*/
package com.pancake.service;

import java.util.List;

import com.pancake.entity.Classification;

/**
* @ClassName: ClassificationService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月17日 下午3:16:49
*
*/
public interface ClassificationService {
	List<Classification> getAllClassifications();
	Classification getClassificationById(int id);
}
