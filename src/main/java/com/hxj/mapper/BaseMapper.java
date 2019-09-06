package com.hxj.mapper;

import com.hxj.page.PageBean;

import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public interface BaseMapper<T>{

    public int add(T t);
    public int update(T t);
    public int delete(int id);
    public T findById(int id);
    public List<T> findAll();
    public int findCount(PageBean params);
    public List<T> findByPage(PageBean params);
    public int addList(List<T> list);
    public int deleteList(int[] ids);

}
