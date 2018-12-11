package com.lianxi.service.impl;

import com.lianxi.domain.Student;
import com.lianxi.mapper.StudentMapper;
import com.lianxi.service.StudentService;
import com.lianxi.vo.PageVo;
import com.lianxi.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public boolean insert(Student student) {

        return studentMapper.insert(student)>0;
    }

    @Override
    public PageVo<Student> queryByPage(int page, int count) {
        PageVo<Student> vo=new PageVo<>();
        int index=0;
        if (page>0){
            index=(page-1)*count;

        }
        List<Student>list=studentMapper.queryByPage(index,count);
        if (list!=null){
            vo.setCode(0);
            vo.setMsg("");
            vo.setData(list);
            vo.setCount(studentMapper.queryCount().intValue());
        }else{
            vo.setCode(1);
            vo.setMsg("暂无数据");
            vo.setData(new ArrayList<>());
            vo.setCount(0);
        }
        return vo;
    }

    @Override
    public Long queryCount(int index, int count) {
        return studentMapper.queryCount();
    }

    @Override
    public ResultVo update(String studentname, Date birthday, int cid, int id) {
        if (studentMapper.update(studentname,birthday,cid,id)>0){
            return ResultVo.setOK("修改成功");
        }else{
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public ResultVo deleteById(int id) {
        if (studentMapper.deleteById(id)>0){
            return ResultVo.setOK("删除成功");
        }else{
            return ResultVo.setERROR("删除失败");
        }
    }


}
