package test.dao;

import test.entity.Delivery;

public interface DeliveryMapper {
    int deleteByPrimaryKey(String jhnm);

    int insert(Delivery record);

    int insertSelective(Delivery record);

    Delivery selectByPrimaryKey(String jhnm);

    int updateByPrimaryKeySelective(Delivery record);

    int updateByPrimaryKey(Delivery record);
}