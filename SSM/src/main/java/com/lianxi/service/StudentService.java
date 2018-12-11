package com.lianxi.service;

import com.lianxi.domain.Student;
import com.lianxi.vo.PageVo;
import com.lianxi.vo.ResultVo;

import java.util.Date;

public interface StudentService {
    boolean insert(Student student);
    PageVo<Student> queryByPage(int page,int count);
    Long queryCount(int index,int count);
    ResultVo update(String studentname, Date birthday,int cid,int id);
    ResultVo deleteById(int id);
}
