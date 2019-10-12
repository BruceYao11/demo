package com.example.demo.service;

import com.example.demo.bean.Student;

import java.util.List;

public interface TestService {

    List<Student> findall();

    int delete(int id);
}
