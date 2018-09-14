package test.dao;

import java.util.List;

import test.entity.Fund;

public interface FundMapper {
    int deleteByPrimaryKey(String id);

    int insert(Fund record);

    int insertSelective(Fund record);

    Fund selectByPrimaryKey(String id);
    
    List<Fund> list();

    int updateByPrimaryKeySelective(Fund record);

    int updateByPrimaryKey(Fund record);
}