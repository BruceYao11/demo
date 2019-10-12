package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.Imp.TestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestServiceImp testService;

    @RequestMapping("/test")
    public String test(){
        return "1";
    }


    @RequestMapping("/list")
    public List<Student> listStudent(HttpServletResponse response, HttpServletRequest request){
        return testService.findall();
    }

    @RequestMapping("/delete/{id}")
    public void delStudent(@PathVariable("id") int id){
        testService.delete(id);
    }
}
