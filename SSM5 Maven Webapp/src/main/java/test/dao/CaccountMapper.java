package test.dao;

import test.entity.Caccount;

public interface CaccountMapper {
    int deleteByPrimaryKey(String id);

    int insert(Caccount record);

    int insertSelective(Caccount record);

    Caccount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Caccount record);

    int updateByPrimaryKey(Caccount record);
}