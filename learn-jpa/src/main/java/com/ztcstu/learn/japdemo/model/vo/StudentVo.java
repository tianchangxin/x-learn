package com.ztcstu.learn.japdemo.model.vo;

import com.ztcstu.learn.japdemo.model.entity.Course;
import com.ztcstu.learn.japdemo.model.entity.Student;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentVo extends Student {
    private Long id;
    private String name;
    private Set<Course> courses = new HashSet<>();
}
