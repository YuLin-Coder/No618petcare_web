package com.pet.dao;

import java.util.List;

import com.pet.entity.Pet;
//宠物信息Dao层
public interface PetDao {
  
    int save(Pet record);//添加
    Pet query(Integer id);//根据id查询当前类信息
    int update(Pet record);//修改
    List<Pet> getPage(int pageNum, int pageSize);//分页查询
    List<Pet> findAll();//查询所有
    List<Pet> findByMap(String name);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
}
   
