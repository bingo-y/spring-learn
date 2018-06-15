package com.bingo.chapter31;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter31ApplicationTests {

	MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void testUserController() throws Exception {

        RequestBuilder request = null;

        request = get("/user/list");
	    mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

	    // 保存用户
	    request = post("/user/save").param("id", "1")
                .param("name", "bingo")
                .param("age", "18");
	    mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

	    // 查询用户
	    request = get("/user/1");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"bingo\",\"age\":18}")));

        // 修改用户
        request = put("/user/1")
                .param("name", "java")
                .param("age", "20");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        // 查询用户
        request = get("/user/1");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"java\",\"age\":20}")));

        // 删除用户
        request = delete("/user/1");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

	}

}
