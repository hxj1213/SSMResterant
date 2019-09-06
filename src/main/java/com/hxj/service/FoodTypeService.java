package com.hxj.service;

import com.hxj.domain.FoodType;
import com.hxj.mapper.BaseMapper;
import com.hxj.mapper.FoodTypeMapper;
import com.hxj.page.PageBean;
import org.apache.ibatis.session.SqlSession;
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
public class FoodTypeService extends BaseService<FoodType> {

    @Resource
    FoodTypeMapper foodTypeMapper;

    @Transactional
    public boolean add(FoodType foodType){
       return foodTypeMapper.add(foodType)>0;
    }

    @Transactional
    public boolean add(List<FoodType> foodTypes){
        return foodTypeMapper.addList(foodTypes)>0;
    }

    @Transactional
    public boolean update(FoodType foodType){
        return foodTypeMapper.update(foodType)>0;
    }

    @Transactional
    public boolean delete(int id){
        return foodTypeMapper.delete(id)>0;
    }

    @Transactional
    public boolean delete(int[] ids){
        return foodTypeMapper.deleteList(ids)>0;
    }

    public List<FoodType> findAll(){
        return foodTypeMapper.findAll();
    }

    public FoodType findById(int id){
        return foodTypeMapper.findById(id);
    }

    /**
     *  分页查询待条件
     * @param page    分页对象
     */
    public void findByPage(PageBean<FoodType> page){
        super.findByPage(foodTypeMapper,page);
    }



}
