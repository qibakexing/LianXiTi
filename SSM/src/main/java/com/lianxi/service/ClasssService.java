package com.lianxi.service;

import com.lianxi.domain.Classs;
import com.lianxi.vo.PageVo;
import com.lianxi.vo.ResultVo;


public interface ClasssService{
    boolean save(Classs classs);
    ResultVo updateclassname(String classname,int id);
    PageVo<Classs> queryByPage(int index, int count);
    ResultVo deleteByClassname (String classname);
    Long queryCount(int index,int count);
}
