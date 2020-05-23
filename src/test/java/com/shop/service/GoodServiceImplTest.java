package com.shop.service;

import com.shop.pojo.Good;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GoodServiceImplTest {


    @Test
    public void queryAllGoods() {
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        GoodService goodService = con.getBean("goodServiceImpl", GoodService.class);
        List<Good> goods = goodService.queryAllGoods();
        for (Good good : goods) {
            System.out.println(good);
        }

    }

    @Test
    public void queryGoodsByPage() {
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        GoodService goodService = con.getBean("goodServiceImpl", GoodService.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("cur_page",1);
        map.put("pageSize",3);
        List<Good> goods = goodService.queryGoodsByPage(map);
        for (Good good : goods) {
            System.out.println(good);
        }
    }
}