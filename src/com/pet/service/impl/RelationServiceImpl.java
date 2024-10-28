package com.pet.service.impl;

import java.util.List;

import com.pet.dao.RelationDao;
import com.pet.dao.impl.RelationDaoImpl;
import com.pet.entity.Relation;
import com.pet.service.RelationService;

public class RelationServiceImpl implements RelationService{
	private RelationDao dao=new RelationDaoImpl();

	public int addRelation(Relation record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	public Relation findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	public int updateRelation(Relation record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	public List<Relation> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	public List<Relation> findAllRelation() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Relation> findRelationByMap(String name) {
		// TODO Auto-generated method stub
		return dao.findByMap(name);
	}

	public int queryRelationCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deleteRelation(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	
}
