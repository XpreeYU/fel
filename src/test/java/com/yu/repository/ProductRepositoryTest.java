package com.yu.repository;

import com.FelApplicationTest;
import com.yu.dataBaseObj.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductRepositoryTest extends FelApplicationTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void fandAll() throws Exception{
        List<Product> productList = productRepository.findAll();
        System.out.println("product: " + productList.size());
    }
}