package com.hxj.service;

import com.hxj.domain.Table;
import com.hxj.mapper.TableMapper;
import com.hxj.page.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
@Service
public class TableService extends BaseService<Table>{

    @Resource
    TableMapper tableMapper;

    @Transactional
    public boolean addTable(Table table){
        return tableMapper.add(table)>0;
    }

    @Transactional
    public boolean addTable(List<Table> tables){
        return tableMapper.addList(tables)>0;
    }

    @Transactional
    public boolean updateTable(Table table){
        return tableMapper.update(table)>0;
    }

    @Transactional
    public boolean deleteTable(int id){
        return tableMapper.delete(id)>0;
    }

    @Transactional
    public boolean deleteTable(int[] ids){
        return tableMapper.deleteList(ids)>0;
    }


    public List<Table> findAllTables(){
        return tableMapper.findAll();
    }

    public Table findTableById(int id){
        return tableMapper.findById(id);
    }

    /**
     *  分页查询待条件
     * @param page    分页对象
     */
    public void findTablesByPage(PageBean<Table> page){
        super.findByPage(tableMapper,page);
    }

}
