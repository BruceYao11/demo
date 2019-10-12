package com.example.demo.dao;

import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestDao {

    @Select("select * from student")
    List<Student> findall();

    @Delete("delete from student where id = #{id}")
    int delete(int id);

}
