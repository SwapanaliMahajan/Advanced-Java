
package com.sunbeam;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sunbeam.daos.UserDao;
import com.sunbeam.pojos.User;
@SpringBootTest
 class UserDaoTests {

  @Autowired
  private UserDao userDao;
	@Test
	void testSave() {
		User user=new User(0,"spider","man","spider@gmail.com","spider","9988776655",Date.valueOf("2021-12-23"));
		int count=userDao.save(user);
		assertEquals(1, count);
		
		user=userDao.findLastSaveUser();
		System.out.println(user);
		assertNotEquals(0, user.getId());
		
	}
	
	
	
}