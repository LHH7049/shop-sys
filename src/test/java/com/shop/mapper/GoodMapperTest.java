package com.shop.mapper;

import com.shop.pojo.Good;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class GoodMapperTest {

    @Test
    public void queryAllGoods() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        GoodMapper goodMapper = applicationContext.getBean("goodMapper",GoodMapper.class);
        List<Good> goods = goodMapper.queryAllGoods();
//        goodMapper.queryGoodByID(2);

    }
}