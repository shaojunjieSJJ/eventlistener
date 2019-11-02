package com.sjj.eventlistener.controller;

import com.sjj.eventlistener.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public String testEventListen(){
        studentService.testEventListen();
        return "ok";
    }
}
