package com.pet.service.impl;

import java.util.List;

import com.pet.dao.ProductDao;
import com.pet.dao.impl.ProductDaoImpl;
import com.pet.entity.Product;
import com.pet.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDao dao=new ProductDaoImpl();

	public int addProduct(Product record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	public int updateProduct(Product record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	public List<Product> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Product> findProductByMap(String name) {
		// TODO Auto-generated method stub
		return dao.findByMap(name);
	}

	public int queryProductCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int updateStock(int product_id) {
		// TODO Auto-generated method stub
		return dao.updateStock(product_id);
	}

	
}
