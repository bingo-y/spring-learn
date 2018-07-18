package com.bingo.chapter42;

import com.bingo.chapter42.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter42ApplicationTests {

	@Autowired
	UserService userService;

	@Test
    @Transactional(propagation = Propagation.REQUIRED)
	public void transactionTest() {

		userService.save("oracle", "111111");
		userService.save("oracle2", "111111");
		userService.save("oracle3", "111111");
		userService.save("oracle and mysql is too long", "111111");
		userService.save("oracle", "111111");
		userService.save("oracle", "111111");

	}

}
