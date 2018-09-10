package test.dao;

import org.apache.ibatis.annotations.Param;

import test.entity.Paydetail;

public interface PaydetailMapper {
    int deleteByPrimaryKey(String id);
    
    int deleteByPayId(String bid);

    int insert(Paydetail record);

    int insertSelective(Paydetail record);
    
    int insertToLink(@Param("pid") String pid,@Param("did") String did);

    Paydetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Paydetail record);

    int updateByPrimaryKey(Paydetail record);

}