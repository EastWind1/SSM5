package test.dao;

import test.entity.Material;

public interface MaterialMapper {
    int deleteByPrimaryKey(String wlnm);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String wlnm);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}