package com.hxj.controller;

import com.hxj.domain.Food;
import com.hxj.page.PageBean;
import com.hxj.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
@Controller
@RequestMapping("/food")
public class FoodController {

    @Resource
    FoodService foodService;

    @RequestMapping("/findByPage.action")
    public @ResponseBody
    PageBean<Food> findByPage(PageBean<Food> FoodPageBean){
        foodService.findByPage(FoodPageBean);
        return FoodPageBean;
    }


    @ResponseBody
    @RequestMapping("/update.action")
    public String update(Food Food){
        System.out.println(Food);
        if(foodService.update(Food)){
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping("/delete.action")
    public String delete(int id){
        System.out.println(id);
        if(foodService.delete(id)){
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping("/add.action")
    public String add(Food Food){
        System.out.println(Food);
        if(foodService.add(Food)){
            return "success";
        }
        return "fail";
    }

}
