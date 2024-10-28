package com.pet.service;

import java.util.List;

import com.pet.entity.Pet;
//业务层宠物信息
public interface PetService {
  
    int addPet(Pet record);//添加
    Pet findById(Integer id);//根据id查询当前类信息
    int updatePet(Pet record);//修改
    List<Pet> getPage(int pageNum, int pageSize);//分页查询
    List<Pet> findAllPet();//查询所有宠物信息
    List<Pet> findPetByMap(String name);//条件查询
    int queryPetCount();//统计数量
    int deletePet(Integer id);//根据id数量
}
   
