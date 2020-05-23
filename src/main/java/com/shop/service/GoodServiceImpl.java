package com.shop.service;

import com.shop.mapper.GoodMapper;
import com.shop.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    @Qualifier("goodMapper")
    private GoodMapper goodMapper;

//    public void setGoodMapper(GoodMapper goodMapper) {
//        this.goodMapper = goodMapper;
//    }

    public int addGood(Good good) {
        return goodMapper.addGood(good);
    }

    public int deleteGood(int id) {
        return goodMapper.deleteGood(id);
    }

    public int updateGood(Good good) {
        return goodMapper.updateGood(good);
    }

    public Good queryGoodByName(String name) {
        return goodMapper.queryGoodByName(name);
    }

    public Good queryGoodByID(int id) {
        return goodMapper.queryGoodByID(id);
    }

    public List<Good> queryAllGoodByName(String name) {
        return goodMapper.queryAllGoodByName(name);
    }

    public List<Good> queryAllGoods() {
        return goodMapper.queryAllGoods();
    }

    public List<Good> queryGoodsByPage(Map<String,Integer> map) {
        return goodMapper.queryGoodsByPage(map);
    }


    public int queryGoodSum(){
        return goodMapper.queryGoodSum();
    }
}
