package com.ztcstu.learn.japdemo.service.impl;

import com.ztcstu.learn.japdemo.model.dto.StudentDto;
import com.ztcstu.learn.japdemo.model.entity.Student;
import com.ztcstu.learn.japdemo.repositories.StudentRepository;
import com.ztcstu.learn.japdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @PersistenceContext
    private EntityManager entityManager;

    // sql 查询
    @Override
    public List<Student> findByName(String name) {
        String jpql = "select s from Student s where s.name like CONCAT('%', :name, '%')";
        TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public void deleteStudentWithCourse(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void update(Long id, StudentDto dto) {
//        Optional<Student> byId = studentRepository.findById(id);
        studentRepository.findById(id).ifPresent(student  -> {
            // 需要更新的数据，并校验空
            BeanUtils.copyProperties(dto, student);
//            student.setName(dto.getName());
//            student.setPhone(dto.getPhone());
            studentRepository.save(student);
        });
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
//        Student student = studentRepository.findByIdWithCourses(id).orElse(null);
        return student;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
        System.out.println("添加成功");
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> queryPage(int pageNo, int pageSize, StudentDto studentDto) {
        Specification<Student> spec = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                // 指定查询字段
                Path<Long> id = root.get("id");
                Path<String> name = root.get("name");
                cq.multiselect(id, name);
                // 拼接查询条件
                Predicate p = cb.conjunction();
                if (StringUtils.isNotBlank(studentDto.getName())){
                     p = cb.and(p, cb.like(name, "%" + studentDto.getName() + "%"));
                }
                if (StringUtils.isNotBlank(studentDto.getPhone())){
                    p = cb.and(p, cb.like(name, "%" + studentDto.getPhone() + "%"));
                }
                return p;
            }
        };
        // 排序
        Sort sort = Sort.by(
                Sort.Order.desc("id"),
                Sort.Order.asc("name")
        );
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Student> all = studentRepository.findAll(spec, pageable);
        return all;
    }


}
