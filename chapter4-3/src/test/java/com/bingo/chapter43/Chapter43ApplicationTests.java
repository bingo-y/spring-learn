package com.bingo.chapter43;

import com.bingo.chapter43.domain.User;
import com.bingo.chapter43.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter43ApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void testRedisCache() {
		long start = System.currentTimeMillis();
		User user = userService.findById(1);
		long end = System.currentTimeMillis();
        System.out.println("user1:" + user.getName());
        System.out.println("user1 use time: " + (end - start));
		userService.updateUser(1, "mysql");
		long start2 = System.currentTimeMillis();
		User user2 = userService.findById(1);
		long end2 = System.currentTimeMillis();
		System.out.println("user2:" + user2.getName());
		System.out.println("user2 use time: " + (end2 - start2));
	}

}
