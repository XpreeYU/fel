package com.yu.repository;

import com.yu.dataBaseObj.Formula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormulaRepository extends JpaRepository<Formula, String> {

    public Formula findByFormulaId(Integer formulaId);
}
