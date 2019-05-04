package com.yu.dataBaseObj;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * ClassName User
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/5/3 17:29
 **/
@Entity
@Data
public class Product {

    //id
    @Id
    private Integer id;

    //价格
    private BigDecimal price;

    //数量
    private Integer count;

    //月份
    private String name;


}
