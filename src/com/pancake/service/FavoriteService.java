/**   
* @Title: FavoriteService.java 
* @Package com.pancake.service 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月16日 下午4:09:52 
* @version V1.0   
*/
package com.pancake.service;

import com.pancake.entity.Favorite;
import com.pancake.entity.Page;
import com.pancake.entity.User;

/**
* @ClassName: FavoriteService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月16日 下午4:09:52
*
*/
public interface FavoriteService {
	public void createFavorite(String buyerName, Long goodId);
	public void delete(Favorite favorite);
	public Favorite getById(java.lang.Long id);
	public Favorite getFavByGoodAndBuyer(Long goodId, User buyer);
	public Page<Favorite> GetUserFavsWithPage(int currentPage, int pageSize, String userName);
}
