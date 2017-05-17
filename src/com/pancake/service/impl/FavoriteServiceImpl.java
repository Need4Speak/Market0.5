/**   
* @Title: FavoriteServiceImpl.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月16日 下午4:11:39 
* @version V1.0   
*/
package com.pancake.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.FavoriteDaoImpl;
import com.pancake.dao.impl.UserDaoImpl;
import com.pancake.entity.Favorite;
import com.pancake.entity.Page;
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
	private UserDaoImpl udi = new UserDaoImpl();

	@Override
	public void delete(Favorite favorite) {
		fdi.delete(favorite);

	}

	@Override
	public Favorite getById(Long id) {
		return fdi.findById(id);
	}

	@Override
	public Favorite getFavByGoodAndBuyer(Long goodId, User buyer) {
		// 根据商品和用户来查询相应的收藏信息，如果不存在，则返回 null。
		List<Favorite> favorites = fdi.findByBuyer(buyer);
		Favorite favorite = null;
		for (Favorite eachFavorite : favorites) {
			if (goodId == eachFavorite.getGood().getGoodId()) {
				favorite = eachFavorite;
				break;
			}
		}
		return favorite;
	}

	@Override
	public Page<Favorite> GetUserFavsWithPage(int currentPage, int pageSize, String userName) {
		Page<Favorite> page = new Page<Favorite>();
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);

		// findByUserName 返回值是list，但数据库中有唯一值约束，用户名唯一
		User user = (User) udi.findByUserName(userName).get(0);
		// 分页查询结果集
		List<Favorite> list = fdi.FindUserFavsWithPage(offset, pageSize, user);
		// 总记录数
		List<Favorite> collections = fdi.findByBuyer(user);
		int allRow = collections.size();

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}

}
