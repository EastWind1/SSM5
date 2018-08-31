package test.dao;

import org.apache.ibatis.annotations.Param;

import test.entity.Delivery;

public interface DeliveryMapper {
    int deleteByPrimaryKey(String jhnm);
    
    int deleteByOrder(String sid);

    int insert(Delivery record);
    
    int insertToLink(@Param("sid") String sid,@Param("did") String did);

    int insertSelective(Delivery record);

    Delivery selectByPrimaryKey(String jhnm);

    int updateByPrimaryKeySelective(Delivery record);

    int updateByPrimaryKey(Delivery record);
}