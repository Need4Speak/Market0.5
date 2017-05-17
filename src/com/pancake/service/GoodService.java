package com.pancake.service;

import java.util.List;

import com.pancake.entity.Good;
import com.pancake.entity.GoodWithImage;
import com.pancake.entity.Page;

public interface GoodService {
	public Page<Good> getAllGoodsWithPage(int currentPage, int pageSize);
    public Page<Good> getUserGoodsWithPage(int currentPage, int pageSize, int classificationId, String userName);
    public Good getById(Long id);
    public void saveGood(GoodWithImage good, String picString);
}
