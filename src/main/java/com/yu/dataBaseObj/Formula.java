package com.yu.dataBaseObj;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ClassName Formula
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/5/3 17:37
 **/
@Entity
@Data
public class Formula {

    //公式id
    @Id
    private Integer formulaId;

    //公式
    private String formula;

    //公式描述
    private String formulaDesc;


}
