package com.lianxi.mapper;

import com.lianxi.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface StudentMapper {
    @Insert("insert into t_student(studentname,birthday,picture,cid,createtime) values(#{studentname},#{birthday},#{picture},cid=#{cid},now())")
    int insert(Student student);

    @Select("select id,studentname,birthday,picture,picture,cid from t_student where id=#{id} limit #{rowindex},#{count}")
    @ResultType(Student.class)
    List<Student> queryByPage(@Param("index")int index,@Param("count")int count);
    @Select("select count(*) from t_student")
    @ResultType(Long.class)
    Long queryCount();

    @Update("update t_student set studentname=#{studentname},birthday=#{birthday},picture=#{picture},cid=#{cid} where id=#{id}")
    int update(@Param("studentname")String studentname, @Param("birthday")Date birthday,@Param("cid")int cid,@Param("id")int id);

    @Delete("delete from t_student where id=#{id}")
    int deleteById(int id);
}
