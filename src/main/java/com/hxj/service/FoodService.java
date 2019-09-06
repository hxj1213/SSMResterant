package com.hxj.service;

import com.hxj.domain.Food;
import com.hxj.mapper.FoodMapper;
import com.hxj.page.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
@Service
public class FoodService extends BaseService<Food>{

    @Resource
    FoodMapper foodMapper;

    @Transactional
    public boolean add(Food food){
        return foodMapper.add(food)>0;
    }

    @Transactional
    public boolean add(List<Food> foods){
        return foodMapper.addList(foods)>0;
    }

    @Transactional
    public boolean update(Food food){
        return foodMapper.update(food)>0;
    }

    @Transactional
    public boolean delete(int id){
        return foodMapper.delete(id)>0;
    }

    @Transactional
    public boolean delete(int[] ids){
        return foodMapper.deleteList(ids)>0;
    }

    public Food findById(int id){
        return foodMapper.findById(id);
    }

    /**
     *  分页查询待条件
     * @param page    分页对象
     */
    public void findByPage(PageBean<Food> page){
       super.findByPage(foodMapper,page);
    }

}
