package com.hxj.controller;

import com.hxj.domain.Table;
import com.hxj.page.PageBean;
import com.hxj.service.TableService;
import javafx.scene.control.Tab;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
@Controller
@RequestMapping("/table")
public class TableController {

    @Resource
    TableService tableService;

    @ResponseBody
    @RequestMapping("/findByPage.action")
    public PageBean findByPage(PageBean pageBean){
        tableService.findTablesByPage(pageBean);
        return pageBean;
    }

    @ResponseBody
    @RequestMapping("/update.action")
    public String update(@RequestBody Table table){
        System.out.println(table);
        if(tableService.updateTable(table)){
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping("/delete.action")
    public String delete(int id){
        System.out.println(id);
        if(tableService.deleteTable(id)){
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping("/add.action")
    public String add(Table table){
        System.out.println(table);
        if(tableService.addTable(table)){
            return "success";
        }
        return "fail";
    }


}
