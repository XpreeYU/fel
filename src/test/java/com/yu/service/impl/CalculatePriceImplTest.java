package com.yu.service.impl;

import com.FelApplicationTest;
import com.yu.service.CalculatePrice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class CalculatePriceImplTest extends FelApplicationTest {

    @Autowired
    private CalculatePrice calculatePrice;

    @Test
    public void calculatePriceBymoth() {
        String result = calculatePrice.calculatePriceBymoth();
        System.out.println("result:" + result);
    }
}