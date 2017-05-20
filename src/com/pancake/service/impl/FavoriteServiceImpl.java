/**   
* @Title: FavoriteServiceImpl.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月16日 下午4:11:39 
* @version V1.0   
*/
package com.pancake.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pancake.dao.FavoriteDao;
import com.pancake.dao.GoodDao;
import com.pancake.dao.UserDao;
import com.pancake.entity.Favorite;
import com.pancake.entity.Good;
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
	@Autowired
	private FavoriteDao fd;
	@Autowired
	private UserDao ud;
	@Autowired
	private GoodDao gd;

	@Override
	public void createFavorite(String buyerName, Long goodId) {
		Good good = gd.findById(goodId);
		// buyerName 唯一
		User buyer = (User) ud.findByUserName(buyerName).get(0);
		User seller = good.getUserByOwnerId();
		Timestamp creationTime = new Timestamp(System.currentTimeMillis());
		String description = "test";
		Favorite favorite = new Favorite(buyer, good, seller, creationTime, description);
		fd.save(favorite);
	}

	@Override
	public void delete(Favorite favorite) {
		fd.delete(favorite);

	}

	@Override
	public Favorite getById(Long id) {
		return fd.findById(id);
	}

	@Override
	public Favorite getFavByGoodAndBuyer(Long goodId, User buyer) {
		// 根据商品和用户来查询相应的收藏信息，如果不存在，则返回 null。
		List<Favorite> favorites = fd.findByBuyer(buyer);
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
		User user = (User) ud.findByUserName(userName).get(0);
		// 分页查询结果集
		List<Favorite> list = fd.FindUserFavsWithPage(offset, pageSize, user);
		// 总记录数
		List<Favorite> collections = fd.findByBuyer(user);
		int allRow = collections.size();

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}

}
