package com.shop.controller.admin;

import com.shop.pojo.GoodsType;
import com.shop.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Autowired
    @Qualifier("goodsTypeServiceImpl")
    public GoodsTypeService goodsTypeService;


    /**
     * 查询所有商品类别
     */
    @RequestMapping("/all")
    @ResponseBody
    public List<GoodsType> Goodstype_manager(){
        return goodsTypeService.queryAllGoodsType();
    }


    /**
     * 根据名称查询商品类别
     */
    @RequestMapping("/search")
    @ResponseBody
    public List<GoodsType> GoodsType_search(@RequestParam("name") String name){
        return goodsTypeService.queryAllGoodsTypeByName(name);
    }


    /**
     * 跳转至添加页面
     */
    @RequestMapping("/toAddGoodsType")
    public String toAddGoodsType(){

        return "admin/addGoodsType";
    }

    /**
     * 添加商品类别
     * @param goodsType
     * @return
     */
    @RequestMapping("/addGoodsType")
    public String addGoodsType(GoodsType goodsType){
        goodsTypeService.addGoodsType(goodsType);
        return "redirect:/admin";
    }


    /**
     * 跳转至更新商品类别
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/toUpdateGoodsType/{id}",method = RequestMethod.GET)
    public String toUpdateGoodsType(@PathVariable("id") Integer id, Model model){
        GoodsType goodsType = goodsTypeService.queryGoodsTypeByID(id);
        model.addAttribute("oldGoodsType",goodsType);
        return "admin/updateGood";
    }

    /**
     * 更新商品
     * @param goodsType
     * @return
     */
    @RequestMapping("/updateGoodsType")
    public String updateGoodsType(GoodsType goodsType){
        goodsTypeService.updateGoodsType(goodsType);
        return "redirect:/admin";
    }

    /**
     * 删除商品类别
     * @param id
     * @return
     */
    @RequestMapping("/deleteGoodsType")
    @ResponseBody
    public String deleteGoodsType(@RequestParam("id") int id){
        goodsTypeService.deleteGoodsType(id);
        return "delete  "+id+"  successful";
    }

    /**
     * 添加分页
     * @param cur_page
     * @param pageSize
     * @return
     */
    @RequestMapping("/pagination")
    @ResponseBody
    public List<GoodsType> paginateGood(
            @RequestParam("cur_page") int cur_page,
            @RequestParam("pageSize") int pageSize
    ){
        //request 当前页面cur_page  一页显示数量pageSize
        //respond 符合数量的数据
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("cur_page",cur_page);
        map.put("pageSize",pageSize);
        return goodsTypeService.queryGoodsTypeByPage(map);
    }

    /**
     * 商品类别总数
     * @return
     */
    @RequestMapping("/goodsTypeSum")
    @ResponseBody
    public String goodSum(){
        return Integer.toString(goodsTypeService.queryGoodsTypeSum());
    }


}
