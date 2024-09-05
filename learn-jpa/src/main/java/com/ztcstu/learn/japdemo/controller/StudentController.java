package com.ztcstu.learn.japdemo.controller;

import com.ztcstu.learn.japdemo.common.BaseResponse;
import com.ztcstu.learn.japdemo.model.dto.StudentDto;
import com.ztcstu.learn.japdemo.model.entity.Course;
import com.ztcstu.learn.japdemo.model.entity.Student;
import com.ztcstu.learn.japdemo.repositories.CourseRepository;
import com.ztcstu.learn.japdemo.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private CourseRepository courseRepository;

    @GetMapping("/list")
    public BaseResponse<List<Student>> list(String name) {
        List<Student> list = studentService.findByName(name);
        return new BaseResponse<>(0, list);
    }

    @GetMapping("/page")
    public BaseResponse<Page<Student>> page() {
        int page = 0;
        int size = 10;
        StudentDto studentDto = new StudentDto();
        // studentDto.setName("大");
        Page<Student> list = studentService.queryPage(page, size, studentDto);
        return new BaseResponse<>(0, list);
    }

    @GetMapping("/{id}")
    public BaseResponse<Student> getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        return new BaseResponse<>(0, student);
    }

    // 新增学生信息(只新增学生信息)
    @PostMapping("/add")
    public BaseResponse<Student> addStudent() {
        Student student = new Student();
        student.setId(300L);
        student.setName("张三1");
        student.setPhone("123456789");
        studentService.addStudent(student);
        return new BaseResponse<>(0, student);
    }


    // 删除学生信息
    @DeleteMapping("/delete/{id}")
    public BaseResponse<String> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return new BaseResponse<>(0, "删除成功");
    }

    // 修改学生信息
    @PutMapping("/update")
    public BaseResponse updateStudent() {
        // 修改id为1 的学生信息
        Long id = 100L;
        StudentDto dto = new StudentDto();
        dto.setName("王五");
        dto.setPhone("123456789");
        studentService.update(id,dto);
        return new BaseResponse<>(0,dto);
    }


    // 新增学生信息(新增学生信息并关联课程)
    @PostMapping("/addWithCourse")
    public BaseResponse<Student> addStudentWithCourse() {
        // 新增学生信息
        Student student = new Student();
        student.setId(400L);
        student.setName("李四");
        // 添加课程
        Course course = new Course();
        course.setId(3L);
        course.setTitle("java");
        // 关联课程
        student.getCourses().add(course);
        studentService.addStudent(student);
        return new BaseResponse<>(0, student,"ok");
    }

    // 删除课程
    @DeleteMapping("/deleteCourse/{id}")
    public BaseResponse<String> deleteCourse(@PathVariable("id") Long id) {
        // 删除课程
        courseRepository.deleteById(id);
        return new BaseResponse<>(0, "删除成功");
    }

    // 删除学生信息(删除学生信息并删除关联课程)
    @DeleteMapping("/deleteWithCourse/{id}")
    public BaseResponse<String> deleteStudentWithCourse(@PathVariable("id") Long id) {
        studentService.deleteStudentWithCourse(id);
        return new BaseResponse<>(0, "删除成功");
    }



}
