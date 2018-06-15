package com.bingo.chapter31;

import com.bingo.chapter31.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author: tyx
 * @Date: create in 2018/6/15 16:08
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<Long, User>());

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> listUser() {
        return new ArrayList<>(userMap.values());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        if (user != null) {
            userMap.put(user.getId(), user);
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userMap.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = userMap.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        userMap.put(id, u);

        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        userMap.remove(id);
        return "success";
    }

}
