package com.shop.service;

import com.shop.mapper.GoodsTypeMapper;
import com.shop.pojo.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    @Qualifier("goodsTypeMapper")
    private GoodsTypeMapper goodsTypeMapper;

    public int addGoodsType(GoodsType goodsType) {
        return goodsTypeMapper.addGoodsType(goodsType);
    }

    public int deleteGoodsType(int id) {
        return goodsTypeMapper.deleteGoodsType(id);
    }

    public int updateGoodsType(GoodsType goodsType) {
        return goodsTypeMapper.updateGoodsType(goodsType);
    }

    public GoodsType queryGoodsTypeByName(String name) {
        return goodsTypeMapper.queryGoodsTypeByName(name);
    }

    public GoodsType queryGoodsTypeByID(int id) {
        return goodsTypeMapper.queryGoodsTypeByID(id);
    }

    public List<GoodsType> queryAllGoodsTypeByName(String name) {
        return goodsTypeMapper.queryAllGoodsTypeByName(name);
    }

    public List<GoodsType> queryAllGoodsType() {
        return goodsTypeMapper.queryAllGoodsType();
    }

    public List<GoodsType> queryGoodsTypeByPage(Map<String, Integer> map) {
        return goodsTypeMapper.queryGoodsTypeByPage(map);
    }

    public int queryGoodsTypeSum() {
        return goodsTypeMapper.queryGoodsTypeSum();
    }
}
