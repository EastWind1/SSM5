package test.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.lang.Nullable;
import test.entity.Pay;

public interface PayMapper {
    int deleteByPrimaryKey(String id);
    
    List<Pay> list(HashMap params);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);
}