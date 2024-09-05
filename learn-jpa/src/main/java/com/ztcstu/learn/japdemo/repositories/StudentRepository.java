package com.ztcstu.learn.japdemo.repositories;

import com.ztcstu.learn.japdemo.model.entity.Student;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>,JpaSpecificationExecutor<Student>{

    /**
     * 根据姓名查询学生id
     * <p>
     * JOIN FETCH
     * 1.减少查询次数：通过一次查询加载多个相关实体。
     * 2.优化性能：避免了 N+1 查询问题(数据库往返带来的性能开销)，提高了整体应用性能。
     * </p>
     * @param studentId
     * @return
     */
    @Query("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :studentId")
    Optional<Student> findByIdWithCourses(@Param("studentId") Long studentId);

}
