package com.sjj.eventlistener.model;

import com.sjj.eventlistener.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by 邵少 on 2019/11/2.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private List<Student> students;
}
