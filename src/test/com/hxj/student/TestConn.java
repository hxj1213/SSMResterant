package com.hxj.student;


import com.hxj.condition.Condition;
import com.hxj.condition.TableCondition;
import com.hxj.domain.Table;
import com.hxj.page.PageBean;
import com.hxj.service.TableService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class TestConn {

    @Test
    public void testConn() throws Exception{

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TableService tableService = (TableService) applicationContext.getBean("tableService");
        System.out.println(tableService);
    }

    @Test
    public void testAddTable()  throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TableService tableService = (TableService) applicationContext.getBean("tableService");
        System.out.println(tableService);
        tableService.addTable(new Table("软件园食堂"));
    }

    @Test
    public void testAddTables()  throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TableService tableService = (TableService) applicationContext.getBean("tableService");
        System.out.println(tableService);
        //4、添加餐桌
        List<Table> tables = new ArrayList<>();
        tables.add(new Table("巴山夜雨"));
        tables.add(new Table("紫竹林"));
        tables.add(new Table("南天门"));
        tableService.addTable(tables);
    }



   /*

 @Test
    public void testupdateTable()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、添加餐桌
        int i = sqlSession.update("tableMapper.updateTable",new Table(1,"四方街",0,null));
        System.out.println("修改："+i);
        //5、提交
        sqlSession.commit();
    }



    @Test
    public void testdelTable()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、添加餐桌
        int i = sqlSession.delete("tableMapper.delTable",1);
        System.out.println("删除："+i);
        //5、提交
        sqlSession.commit();
    }

    @Test
    public void testdelTables()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、添加餐桌
        int i = sqlSession.delete("tableMapper.delTables",new int[]{10,11});
        System.out.println("删除："+i);
        //5、提交
        sqlSession.commit();
    }


    @Test
    public void testfindTables()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、查询餐桌
        List<Table> tables= sqlSession.selectList("tableMapper.findAllTables");
        System.out.println(tables);
    }

    @Test
    public void testfindById()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、查询餐桌
        Table table= sqlSession.selectOne("tableMapper.findTableById",2);
        System.out.println(table);
    }

    */

    @Test
    public void testfindByPage()  throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TableService tableService = (TableService) applicationContext.getBean("tableService");
        System.out.println(tableService);

        PageBean<Table> page = new PageBean<>(1,5);

        //4、查询餐桌
        /*Condition params = new TableCondition();
        ((TableCondition) params).setTableName("光");*/
        HashMap params = page.getCondition();
        params.put("tableName","光");
        /*params.put("tableStatue",0);
        params.put("startTime",new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        params.put("endTime",simpleDateFormat.parse("2019-08-27 09:34:20"));*/

        System.out.println(page);

        tableService.findTablesByPage(page);

        System.out.println(page);
    }
}
