package com.sjj.eventlistener.repository;

import com.sjj.eventlistener.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {


}
