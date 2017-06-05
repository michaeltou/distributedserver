package com.tm.yunmo.datacenter;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by daoying on 2017/3/13.
 */

@Controller
public class DataCenter {


    @ApiOperation(value="根据id查询数据", notes="根据身份证id查询详细的风控数据")
    @RequestMapping("/queryDataById")
    public String queryDataById( ModelMap model){
        model.addAttribute("host", "http://blog.didispace.com");

        return "queryDataByIdResult";
    }



    @RequestMapping("/datacenter")
    public String getData(@RequestParam("id")  String id, Map<String,Object> model){

        System.out.println("the id is:"+id);

        List<String> l=  new ArrayList<>();
        l.add("哈喽，hadoop");
        l.add("哈喽，hbase");
        l.add("哈喽，hive");
        l.add("哈喽，pig");
        l.add("哈喽，zookeeper");
        l.add("哈喽，三劫散仙");
        l.add(id);
        //将数据存放map里面，可以直接在velocity页面，使用key访问
        model.put("data",l);

        return "hello";
    }


    @RequestMapping("/dchello")
    public String hello(@RequestParam("id")  String id, Map<String,Object> model){

        System.out.println("the id is:"+id);

        List<String> l=  new ArrayList<>();
        l.add("哈喽，hadoop");
        l.add("哈喽，hbase");
        l.add("哈喽，hive");
        l.add("哈喽，pig");
        l.add("哈喽，zookeeper");
        l.add("哈喽，三劫散仙");
        l.add(id);
        //将数据存放map里面，可以直接在velocity页面，使用key访问
        model.put("data",l);

        return "hello";
    }
}
