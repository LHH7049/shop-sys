package com.shop.service;

import com.shop.pojo.GoodsType;

import java.util.List;
import java.util.Map;


public interface GoodsTypeService {
    //增加一个商品类别
    int addGoodsType(GoodsType good);

    //删除一个商品类别
    int deleteGoodsType(int id);

    //修改一个商品类别
    int updateGoodsType(GoodsType good);

    //根据名称查找商品类别
    GoodsType queryGoodsTypeByName(String name);

    //根据id查找商品类别
    GoodsType queryGoodsTypeByID(int id);

    //根据名称模糊查找
    List<GoodsType> queryAllGoodsTypeByName(String name);

    //查找所有商品类别
    List<GoodsType> queryAllGoodsType();

    //根据页数和指定数量查找数据(分页)
    List<GoodsType> queryGoodsTypeByPage(Map<String,Integer> map);

    //获得数据总量
    int queryGoodsTypeSum();
}
