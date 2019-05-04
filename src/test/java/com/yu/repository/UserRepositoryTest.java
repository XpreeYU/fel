package com.yu.repository;

import com.FelApplicationTest;
import com.yu.dataBaseObj.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class UserRepositoryTest extends FelApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll() throws Exception {
        List<User> userList = userRepository.findAll();

        System.out.println("result: " + userList);

    }
}