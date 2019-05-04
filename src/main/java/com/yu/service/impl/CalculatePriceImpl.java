package com.yu.service.impl;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import com.yu.dataBaseObj.Formula;
import com.yu.dataBaseObj.User;
import com.yu.repository.FormulaRepository;
import com.yu.repository.UserRepository;
import com.yu.service.CalculatePrice;
import com.yu.utils.ObjectFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName CalculatePriceImpl
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/5/3 18:09
 **/
@Service
public class CalculatePriceImpl implements CalculatePrice {

    @Autowired
    private FormulaRepository formulaRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String calculatePriceBymoth() {
        //1.获取公式
        Formula formula = formulaRepository.findByFormulaId(1);
        //2. 获取数据
        User user = userRepository.findById(1);

        //3. 计算价格
        FelEngine fel = new FelEngineImpl();
        FelContext ctx = fel.getContext();
        ObjectFieldUtil.setFelContext(ctx, user);
        Object result = fel.eval(formula.getFormula());



        return result.toString();
    }



}
