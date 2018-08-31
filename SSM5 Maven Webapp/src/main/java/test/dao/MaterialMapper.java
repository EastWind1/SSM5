package test.dao;

import org.apache.ibatis.annotations.Param;

import test.entity.Material;

public interface MaterialMapper {
    int deleteByPrimaryKey(String wlnm);
    
    int deleteByOrder(String sid);

    int insert(Material record);
    
    int insertToLink(@Param("sid") String sid,@Param("mid") String mid);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String wlnm);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}