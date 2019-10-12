package com.example.demo.service.Imp;

import com.example.demo.bean.Student;
import com.example.demo.dao.TestDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImpTest {

    @Mock
    private TestDao testDao;

    @InjectMocks
    private TestServiceImp testServiceImp;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findall() {
        Student student = new Student(3,"Tom",30);
        List<Student> list = new ArrayList<>();
        list.add(student);
        when(testDao.findall()).thenReturn(list);
        List<Student> students = testServiceImp.findall();
        System.out.println(students);
        assertEquals(list, students);
    }

    @Test
    public void delete() {
        when(testDao.delete(3)).thenReturn(1);
        int result = testServiceImp.delete(3);
        assertEquals(1,result);
    }
}