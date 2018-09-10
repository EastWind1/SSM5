package test.dao;

import java.util.List;

import test.entity.Pay;

public interface PayMapper {
    int deleteByPrimaryKey(String id);
    
    List<Pay> list();

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);
}