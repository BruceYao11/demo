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
@RequestMapping("/demo")
public class TestController {

    @Autowired
    private TestServiceImp testService;

    @RequestMapping("/test")
    public String test(){
        return "1";
    }


    @RequestMapping("/list")
    public List<Student> listStudent(){
        return testService.findall();
    }

    @RequestMapping("/delete/{id}")
    public int delStudent(@PathVariable("id") int id){
        return testService.delete(id);
    }

    @RequestMapping("/insert")
    public int insertStudent(Student student){
        return testService.insert(student);
    }

    @RequestMapping("/update")
    public int updateStudent(Student student){
        return testService.update(student);
    }
}
