package com.pet.service.impl;

import java.util.List;

import com.pet.dao.CategoryDao;
import com.pet.dao.impl.CategoryDaoImpl;
import com.pet.entity.Category;
import com.pet.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private CategoryDao dao=new CategoryDaoImpl();

	public int addCategory(Category record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	public int updateCategory(Category record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	public List<Category> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Category> findCategoryByMap(String name) {
		// TODO Auto-generated method stub
		return dao.findByMap(name);
	}

	public int queryCategoryCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	
}
