/**   
* @Title: FavoriteServiceImpl.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月16日 下午4:11:39 
* @version V1.0   
*/
package com.pancake.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.FavoriteDaoImpl;
import com.pancake.entity.Favorite;
import com.pancake.entity.User;
import com.pancake.service.FavoriteService;

/**
* @ClassName: FavoriteServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月16日 下午4:11:39
*
*/
@Service
public class FavoriteServiceImpl implements FavoriteService {

	private FavoriteDaoImpl fdi = new FavoriteDaoImpl();
	@Override
	public Favorite getFavByGoodAndBuyer(Long goodId, User buyer) {
		// 根据商品和用户来查询相应的收藏信息，如果不存在，则返回 null。
		List<Favorite> favorites = fdi.findByBuyer(buyer);
		Favorite favorite = null;
		for (Favorite eachFavorite : favorites) {
			if(goodId == eachFavorite.getGood().getGoodId()){
				favorite = eachFavorite;
				break;
			}
		}
		return favorite;
	}

}
