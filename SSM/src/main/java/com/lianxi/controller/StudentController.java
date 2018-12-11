package com.lianxi.controller;

import com.lianxi.domain.Student;
import com.lianxi.service.StudentService;
import com.lianxi.vo.PageVo;
import com.lianxi.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/",method = {RequestMethod.POST})
    public String insert(Student student){
        if (studentService.insert(student)){
            return "";
        }else{
            return "";
        }
    }

    @RequestMapping(value = "/",method = {RequestMethod.POST})
    @ResponseBody
    public PageVo<Student> queryPage(int page,int limit){
        return studentService.queryByPage(page,limit);

    }
    //修改基于from表单
    @RequestMapping(value = "/",method = {RequestMethod.POST})
    public String update(String studentname, Date birthday, int cid, int id){
        if (studentService.update(studentname,birthday,cid,id).getCode()==1000){
            return "";
        }else{
            return "";
        }
    }

    @RequestMapping(value = "/",method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo deleteById(int id){
        return studentService.deleteById(id);
    }
}


