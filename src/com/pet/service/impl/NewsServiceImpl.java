package com.pet.service.impl;

import java.util.List;

import com.pet.dao.NewsDao;
import com.pet.dao.impl.NewsDaoImpl;
import com.pet.entity.News;
import com.pet.service.NewsService;

public class NewsServiceImpl implements NewsService{
	private NewsDao dao=new NewsDaoImpl();

	public int addNews(News record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	public News findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	public int updateNews(News record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	public List<News> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	public List<News> findAllNews() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<News> findNewsByMap(String name) {
		// TODO Auto-generated method stub
		return dao.findByMap(name);
	}

	public int queryNewsCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deleteNews(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	
}
