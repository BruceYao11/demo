package com.example.demo.dao;

import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TestDao {

    @Select("select * from student")
    List<Student> findall();

    @Delete("delete from student where id = #{id}")
    int delete(int id);

    @Insert("insert into student values(#{id},#{name},#{age})")
    int insert(Student student);

    @Update("update student set name = #{name},age = #{age} where id = #{id}")
    int update(Student student);
}
