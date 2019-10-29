package com.example.demo.service.Imp;

import com.example.demo.bean.Student;
import com.example.demo.dao.TestDao;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImp implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Student> findall() {
        return testDao.findall();
    }

    @Override
    public int delete(int id) {
        return testDao.delete(id);
    }

    @Override
    public int insert(Student student) {
        return testDao.insert(student);
    }

    @Override
    public int update(Student student) {
        return testDao.update(student);
    }
}
