package com.pet.dao;

import java.util.List;

import com.pet.entity.Relation;
//用户联系dao层
public interface RelationDao {
  
    int save(Relation record);//添加
    Relation query(Integer id);//根据id查询当前类信息
    int update(Relation record);//修改
    List<Relation> getPage(int pageNum, int pageSize);//分页查询
    List<Relation> findAll();//查询所有
    List<Relation> findByMap(String name);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
}
   
