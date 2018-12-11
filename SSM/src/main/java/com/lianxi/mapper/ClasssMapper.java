package com.lianxi.mapper;


import com.lianxi.domain.Classs;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClasssMapper {
    @Insert("insert into t_classs(classname,createtime) values(#{classname},now())")
    int save(Classs classs);
    @Update("update  t_classs set classname=#{classname} where id=#{id}")
    int updateclassname(@Param("classname")String classname, @Param("id")int id);
    @Select("select id,classname from t_classs where classname=#{classname} limit #{rowindex},#{count}")
    @ResultType(Classs.class)
    List<Classs> queryByPage(@Param("index")int index,@Param("count")int count);
    @Delete("delete from t_classs where classname=#{classname}")
    Classs deleteByClassname (String classname);
    @Select("select count(*) from t_class")
    @ResultType(Long.class)
    Long queryCount();
}
