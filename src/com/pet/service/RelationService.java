package com.pet.service;

import java.util.List;

import com.pet.entity.Relation;
//业务层用户联系
public interface RelationService {
  
    int addRelation(Relation record);//添加
    Relation findById(Integer id);//根据id查询当前类信息
    int updateRelation(Relation record);//修改
    List<Relation> getPage(int pageNum, int pageSize);//分页查询
    List<Relation> findAllRelation();//查询所有用户联系
    List<Relation> findRelationByMap(String name);//条件查询
    int queryRelationCount();//统计数量
    int deleteRelation(Integer id);//根据id数量
}
   
