package test.dao;


import java.util.List;

import test.entity.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByUserName(String userName);
    
    List<User> selectList();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}