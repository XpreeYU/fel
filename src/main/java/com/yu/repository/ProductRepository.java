package com.yu.repository;

import com.yu.dataBaseObj.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName UserRepository
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/5/3 17:39
 **/
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findById(Integer id);
}
