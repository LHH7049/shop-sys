package com.shop.service;

import com.shop.pojo.Good;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface GoodService {

    //增加一个商品
    int addGood(Good good);

    //删除一个商品
    int deleteGood(int id);

    //修改一个商品
    int updateGood(Good good);

    //根据名称查找商品
    Good queryGoodByName(String name);

    //根据id查找商品
    Good queryGoodByID(int id);

    //根据名称模糊查找
    List<Good> queryAllGoodByName(String name);

    //查找所有商品
    List<Good> queryAllGoods();

    //根据页数和指定数量查找数据(分页)
    List<Good> queryGoodsByPage(Map<String,Integer> map);

    //获得数据总量
    int queryGoodSum();
}
