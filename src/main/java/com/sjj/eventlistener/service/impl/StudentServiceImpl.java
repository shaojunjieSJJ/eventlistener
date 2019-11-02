package com.sjj.eventlistener.service.impl;

import com.google.common.collect.Lists;
import com.sjj.eventlistener.entity.Student;
import com.sjj.eventlistener.entity.Teacher;
import com.sjj.eventlistener.event.StudentEvent;
import com.sjj.eventlistener.event.TeacherEvent;
import com.sjj.eventlistener.model.StudentDTO;
import com.sjj.eventlistener.repository.StudentRepository;
import com.sjj.eventlistener.repository.TeacherRepository;
import com.sjj.eventlistener.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void testEventListen() {

        List<Student> studentList = Lists.newArrayList(new Student(0, "小明", 20), new Student(0, "小亮", 24));
        List<Student> students = studentRepository.saveAll(studentList);
        // 一,二会监听到事件,传递List和Object皆可
        applicationEventPublisher.publishEvent(new StudentEvent<>(students));
//        applicationEventPublisher.publishEvent(new StudentEvent<>(new Student(0, "小明", 20)));

        List<Teacher> teacherList = Lists.newArrayList(new Teacher(0, "张老师", 38, "数学"), new Teacher(0, "凯老师", 35, "语文"));
        List<Teacher> teachers = teacherRepository.saveAll(teacherList);
        // 三,传递List和Object皆可
        applicationEventPublisher.publishEvent(new TeacherEvent(teachers));
//        applicationEventPublisher.publishEvent(new TeacherEvent(new Teacher(0, "张老师", 38, "数学")));

        // 四,传递Object
        applicationEventPublisher.publishEvent(new Student(0, "小李", 18));

        // 五,传递Object,但Object中封装的有List
        StudentDTO studentDTO = new StudentDTO(Lists.newArrayList(new Student(0, "小明DTO", 20), new Student(0, "小亮DTO", 24)));
        applicationEventPublisher.publishEvent(studentDTO);

    }


}
