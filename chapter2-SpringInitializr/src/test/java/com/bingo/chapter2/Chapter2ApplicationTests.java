package com.bingo.chapter2;

import com.bingo.chapter2.config.BingoProperty;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter2ApplicationTests {

	@Autowired
	BingoProperty bingoProperty;

	@Test
	public void getProperties() {
		Assert.assertEquals(bingoProperty.getName(), "baby");
		Assert.assertEquals(bingoProperty.getTitle(), "spring boot");
		Assert.assertEquals(bingoProperty.getValue(), 1);
	}

	@Test
	public void contextLoads() {
	}

}
