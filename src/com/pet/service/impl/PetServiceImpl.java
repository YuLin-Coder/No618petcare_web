package com.pet.service.impl;

import java.util.List;


import com.pet.dao.PetDao;
import com.pet.dao.impl.PetDaoImpl;
import com.pet.entity.Pet;
import com.pet.service.PetService;

public class PetServiceImpl implements PetService{
	private PetDao dao=new PetDaoImpl();

	public int addPet(Pet record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	public Pet findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	public int updatePet(Pet record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	public List<Pet> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	public List<Pet> findAllPet() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Pet> findPetByMap(String name) {
		// TODO Auto-generated method stub
		return dao.findByMap(name);
	}

	public int queryPetCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deletePet(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	
}
