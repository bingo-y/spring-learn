package com.bingo.chapter42.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    void save(String name, String password);

}
