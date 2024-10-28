package com.pet.service.impl;

import java.util.List;

import com.pet.dao.BannerDao;
import com.pet.dao.impl.BannerDaoImpl;
import com.pet.entity.Banner;
import com.pet.service.BannerService;

public class BannerServiceImpl implements BannerService{
	private BannerDao dao=new BannerDaoImpl();

	public int addBanner(Banner record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	public Banner findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	public int updateBanner(Banner record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	public List<Banner> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	public List<Banner> findAllBanner() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Banner> findBannerByMap(String name) {
		// TODO Auto-generated method stub
		return dao.findByMap(name);
	}

	public int queryBannerCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deleteBanner(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	
}
