package test.dao;

import java.util.List;

import test.entity.Linterest;

public interface LinterestMapper {
    int deleteByPrimaryKey(Integer lId);

    int insert(Linterest record);

    int insertSelective(Linterest record);

    Linterest selectByPrimaryKey(Integer lId);
    
    List<Linterest> list();

    int updateByPrimaryKeySelective(Linterest record);

    int updateByPrimaryKey(Linterest record);
}