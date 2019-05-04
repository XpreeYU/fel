package com.yu.repository;

import com.yu.dataBaseObj.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName UserRepository
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/5/3 17:39
 **/
public interface UserRepository extends JpaRepository<User, String> {
    User findById(Integer id);
}
