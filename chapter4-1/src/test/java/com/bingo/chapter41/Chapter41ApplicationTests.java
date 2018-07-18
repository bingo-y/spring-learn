package com.bingo.chapter41;

import com.bingo.chapter41.domain.User;
import com.bingo.chapter41.mapper.UserMapper;
import com.bingo.chapter41.service.UserService;
import net.sf.ehcache.CacheManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter41ApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    private CacheManager cacheManager;

	@Test
	public void testRedis() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Test
	public void testMybatis() {
        User user = userMapper.findById(1);
        Assert.assertEquals("mysql", user.getName());
    }

    @Test
    public void testMybatis2() {
        User user = userMapper.findByName("mysql");
        Assert.assertEquals("18626882100", user.getPhone());
        Assert.assertNull(user.getId());
    }

    @Test
    @Rollback
    public void testInsertUser() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "php");
        map.put("phone", "183695584448");
        userMapper.insertUser(map);
    }

    @Test
    public void testEhcache() {
	    long start = System.currentTimeMillis();
        User user = userService.findById(1);
        long end = System.currentTimeMillis();
        userService.updateUser(1, "sqlserver");
        long start2 = System.currentTimeMillis();
        User user2 = userService.findById(1);
        long end2 = System.currentTimeMillis();
        System.out.println("user1:" + user.getName());
        System.out.println("user1 use time: " + (end - start));
        System.out.println("user2:" + user2.getName());
        System.out.println("user2 use time: " + (end2 - start2));
    }

}
