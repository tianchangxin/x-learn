package com.ztcstu.learn.japdemo.service;

import com.ztcstu.learn.japdemo.model.dto.StudentDto;
import com.ztcstu.learn.japdemo.model.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    Student getStudentById(Long id);

    void addStudent(Student student);

    void deleteStudent(Long id);

    Page<Student> queryPage(int pageNo, int pageSize, StudentDto studentDto);

    List<Student> findByName(String name);


    void deleteStudentWithCourse(Long id);

    void update(Long id, StudentDto dto);
}
