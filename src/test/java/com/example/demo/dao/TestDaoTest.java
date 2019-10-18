package com.example.demo.dao;

import com.example.demo.bean.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
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
        int a = 1;
        int b = 3;
        Assert.assertEquals(1, a);
    }
}