package com.lianxi.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.lianxi.domain.Classs;
import com.lianxi.service.ClasssService;
import com.lianxi.vo.PageVo;
import com.lianxi.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClasssController {
    @Autowired
    private ClasssService classsService;

    //
    @RequestMapping(value = "/zeng.do",method = {RequestMethod.GET})
    public String save(Classs classs){
        if (classsService.save(classs)){
            return "";
        }else {
            return "";
        }
    }
    //修改基于ajax
    @RequestMapping(value = "/gai.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo updateclassname(String classname,int id){
        return classsService.updateclassname(classname,id);
    }
    //
    @RequestMapping(value = "/cha.do",method = {RequestMethod.POST})
    @ResponseBody
    public PageVo<Classs> queryByPage(int index,int count){
        return classsService.queryByPage(index,count);
    }
    //
    @RequestMapping(value = "/shan.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo deleteByClassname(String classname){
        return classsService.deleteByClassname(classname);
    }
}
