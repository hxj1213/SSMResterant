package com.hxj.controller;

import com.hxj.domain.FoodType;
import com.hxj.page.PageBean;
import com.hxj.service.FoodTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
@Controller
@RequestMapping("/type")
public class FoodTypeController {

    @Resource
    FoodTypeService foodTypeService;

    @RequestMapping("/findByPage.action")
    public @ResponseBody
    PageBean<FoodType> findByPage(PageBean<FoodType> foodTypePageBean){
        foodTypeService.findByPage(foodTypePageBean);
        return foodTypePageBean;
    }

    @RequestMapping("/findAll.action")
    public @ResponseBody
    List<FoodType> findAll(){
        return foodTypeService.findAll();
    }

    @ResponseBody
    @RequestMapping("/update.action")
    public String update(FoodType foodType){
        System.out.println(foodType);
        if(foodTypeService.update(foodType)){
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping("/delete.action")
    public String delete(int id){
        System.out.println(id);
        if(foodTypeService.delete(id)){
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping("/add.action")
    public String add(FoodType foodType){
        System.out.println(foodType);
        if(foodTypeService.add(foodType)){
            return "success";
        }
        return "fail";
    }

}
