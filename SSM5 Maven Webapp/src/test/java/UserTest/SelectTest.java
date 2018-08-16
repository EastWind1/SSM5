package UserTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.dao.UserDao;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml","classpath:spring/spring-db.xml"})     
public class SelectTest  {
	@Autowired
	private UserDao userDao;
	@Test
	public void test() {
		userDao.selectList();
	}

}
