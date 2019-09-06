package com.hxj.service;

import com.hxj.domain.FoodType;
import com.hxj.mapper.BaseMapper;
import com.hxj.page.PageBean;

import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class BaseService<T>{

    public void findByPage(BaseMapper mapper,PageBean page){
        //查询总记录数
        int count =  mapper.findCount(page);
        page.setTotalRows(count);

        List datas = mapper.findByPage(page);
        page.setData(datas);

        System.out.println(page);
    }

}
