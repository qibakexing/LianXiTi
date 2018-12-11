package com.lianxi.service.impl;

import com.lianxi.domain.Classs;
import com.lianxi.mapper.ClasssMapper;
import com.lianxi.service.ClasssService;
import com.lianxi.vo.PageVo;
import com.lianxi.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public class ClasssServiceImpl implements ClasssService {
    @Autowired
    private ClasssMapper classsMapper;


    @Override
    public boolean save(Classs classs) {
        return classsMapper.save(classs)>0;
    }

    @Override
    public ResultVo updateclassname(String classname,int id) {
        if (classsMapper.updateclassname(classname,id)>0){
            return ResultVo.setOK("修改成功");
        }else{
            return ResultVo.setERROR("修改成功");
        }
    }


    @Override
    public PageVo<Classs> queryByPage(int page, int count) {
        // TODO Auto-generated method stub
        PageVo<Classs> vo=new PageVo<>();
        int index=0;
        if(page>0) {
            index=(page-1)*count;
        }
        List<Classs> list=classsMapper.queryByPage(index, count);
        if(list!=null) {
            vo.setCode(0);
            vo.setMsg("");
            vo.setData(list);
            vo.setCount(classsMapper.queryCount().intValue());
        }else {
            vo.setCode(1);
            vo.setMsg("暂无数据");
            vo.setData(new ArrayList<>());
            vo.setCount(0);
        }
        return vo;
    }


    @Override
    public ResultVo deleteByClassname(String classname) {
        if (classsMapper.deleteByClassname(classname)!=null){
            return ResultVo.setOK("删除成功");
        }else{
            return ResultVo.setERROR("删除失败");
        }
    }

    @Override
    public Long queryCount(int index, int count) {
        return classsMapper.queryCount();
    }
}
