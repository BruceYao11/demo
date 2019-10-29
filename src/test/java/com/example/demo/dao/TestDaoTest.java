package com.example.demo.dao;

import com.example.demo.bean.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestDaoTest {

    @Autowired
    private TestDao testDao;

    @Test
    public void findall() {
        List<Student> list = testDao.findall();
        Assert.assertNotNull(list);
    }

    @Test
    public void delete() {
        int result = testDao.delete(1);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insert() {
        Student student = new Student();
        student.setId(10);
        student.setAge(20);
        student.setName("Boss");
        int result = testDao.insert(student);
        Assert.assertEquals(1,result);
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setId(1);
        student.setAge(20);
        student.setName("Boss");
        int result = testDao.update(student);
        Assert.assertEquals(1,result);
    }
}