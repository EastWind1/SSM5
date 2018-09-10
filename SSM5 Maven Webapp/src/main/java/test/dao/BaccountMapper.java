package test.dao;

import java.util.List;

import test.entity.Baccount;

public interface BaccountMapper {
    int deleteByPrimaryKey(String id);

    int insert(Baccount record);

    int insertSelective(Baccount record);

    Baccount selectByPrimaryKey(String id);
    
    List<Baccount> list();

    int updateByPrimaryKeySelective(Baccount record);

    int updateByPrimaryKey(Baccount record);
}