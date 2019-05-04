package com.yu.repository;

import com.FelApplicationTest;
import com.yu.dataBaseObj.Formula;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class FormulaRepositoryTest extends FelApplicationTest {

    @Autowired
    private FormulaRepository formulaRepository;

    @Test
    public void findByFormulaId() throws Exception {
        Formula formula = formulaRepository.findByFormulaId(1);
        System.out.println("formula: " + formula.getFormula());
    }
}