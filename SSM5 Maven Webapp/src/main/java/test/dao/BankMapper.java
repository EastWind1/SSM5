package test.dao;

import java.util.List;

import test.entity.Bank;

public interface BankMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Bank record);

    int insertSelective(Bank record);

    Bank selectByPrimaryKey(Integer bId);
    
    List<Bank> list();

    int updateByPrimaryKeySelective(Bank record);

    int updateByPrimaryKey(Bank record);
}