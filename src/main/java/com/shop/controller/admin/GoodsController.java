package com.shop.controller.admin;

import com.shop.pojo.Good;
import com.shop.pojo.GoodsType;
import com.shop.service.GoodService;
import com.shop.service.GoodsTypeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/good")
public class GoodsController {

    @Autowired
    @Qualifier("goodServiceImpl")
    private GoodService goodService;

    @RequestMapping("/all")
    @ResponseBody
    public List<Good> good_manager(){
        return goodService.queryAllGoods();
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Good> good_search(@RequestParam("name") String name){

        return goodService.queryAllGoodByName(name);
    }

    @RequestMapping("/toAddGood")
    public String toAddGood(Model model){
        //传入商品类型
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GoodsTypeService goodsTypeServiceImpl = context.getBean("goodsTypeServiceImpl", GoodsTypeService.class);
        List<GoodsType> goodsTypes = goodsTypeServiceImpl.queryAllGoodsType();
        model.addAttribute("type",goodsTypes);
        return "admin/addGood";
    }

    @RequestMapping("/addGood")
    public String addGood(Good good){
//        System.out.println(good);
        goodService.addGood(good);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/toUpdateGood/{id}",method = RequestMethod.GET)
    public String toUpdateGood(@PathVariable("id") Integer id,Model model){
        Good good = goodService.queryGoodByID(id);
        //传入商品类型
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GoodsTypeService goodsTypeServiceImpl = context.getBean("goodsTypeServiceImpl", GoodsTypeService.class);
        List<GoodsType> goodsTypes = goodsTypeServiceImpl.queryAllGoodsType();
        model.addAttribute("type",goodsTypes);
        model.addAttribute("oldGood",good);
        return "admin/updateGood";
    }
    @RequestMapping("/updateGood")
    public String updateGood(Good good){
        System.out.println(good);
        goodService.updateGood(good);
        return "redirect:/admin";
    }

    @RequestMapping("/deleteGood")
    @ResponseBody
    public String deleteGood(@RequestParam("id") int id){
        goodService.deleteGood(id);
        return "delete  "+id+"  successful";
    }

    @RequestMapping("/pagination")
    @ResponseBody
    public List<Good> paginateGood(
            @RequestParam("cur_page") int cur_page,
            @RequestParam("pageSize") int pageSize
    ){
        //request 当前页面cur_page  一页显示数量pageSize
        //respond 符合数量的数据
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("cur_page",cur_page);
        map.put("pageSize",pageSize);
        return goodService.queryGoodsByPage(map);
    }

    @RequestMapping("/goodSum")
    @ResponseBody
    public String goodSum(){
        return Integer.toString(goodService.queryGoodSum());
    }

}
