package test.service.impl;


import java.util.List;

import test.dao.UserDao;
import test.entity.User;
import test.service.UserService;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
  
  
  
@Service("userService")  
public class UserServiceImpl implements UserService {  
    @Resource  
    private UserDao userDao;  
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return this.userDao.selectByUserName(userName);
	}
	public int newUser(String userName, String password,Integer age) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setAge(age);
		return this.userDao.insert(user);
	}
	public List<User> list() {
		// TODO Auto-generated method stub
		return this.userDao.selectList();
	}
	
	public int newUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.insert(user);
	}
  
}  
