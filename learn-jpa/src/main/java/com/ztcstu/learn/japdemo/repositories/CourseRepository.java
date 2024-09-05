package com.ztcstu.learn.japdemo.repositories;

import com.ztcstu.learn.japdemo.model.entity.Course;
import com.ztcstu.learn.japdemo.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * @param courseId
     * @return
     */
    @Query("SELECT c FROM Course c WHERE c.id = :courseId")
    Optional<Course> getCourseById(@Param("courseId") Long courseId);

}
