package test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.entity.Interest;

public interface InterestMapper {
    int deleteByPrimaryKey(Integer iId);

    int insert(Interest record);
    
    int insertToLink(@Param("bId") Integer bId,@Param("iId") Integer iId);

    int insertSelective(Interest record);

    Interest selectByPrimaryKey(Integer iId);
    
    List<Interest> list();

    int updateByPrimaryKeySelective(Interest record);

    int updateByPrimaryKey(Interest record);
}