/**   
* @Title: LeaveWords.java 
* @Package com.pancake.service 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月19日 下午7:32:41 
* @version V1.0   
*/
package com.pancake.service;

import java.util.List;

import com.pancake.entity.LeaveWords;

/**
* @ClassName: LeaveWords
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月19日 下午7:32:41
*
*/
public interface LeaveWordsService {
	public void addLeaveWords(String userName, String message, Long goodId);
	public List<LeaveWords> getByGoodId(Long goodId);
}
