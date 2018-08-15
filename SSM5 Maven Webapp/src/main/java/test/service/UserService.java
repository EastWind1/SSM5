package test.service;  


import java.util.List;

import test.entity.User;

  
public interface UserService {  
    public User getUserById(int userId); 
    public User getUserByUserName(String userName);
    public int newUser(String userName,String password,Integer age);
    public int newUser(User user);
    public List<User> list();
}  