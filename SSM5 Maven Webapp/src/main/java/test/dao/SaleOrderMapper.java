package test.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import test.entity.SaleOrder;

public interface SaleOrderMapper {
    int deleteByPrimaryKey(String ddbh);

    int insert(SaleOrder record);

    int insertSelective(SaleOrder record);

    SaleOrder selectByPrimaryKey(String ddbh);

    int updateByPrimaryKeySelective(SaleOrder record);

    int updateByPrimaryKey(SaleOrder record);
    
    List<SaleOrder> list(HashMap map);
}