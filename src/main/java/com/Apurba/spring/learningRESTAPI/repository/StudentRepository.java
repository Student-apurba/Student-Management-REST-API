package com.Apurba.spring.learningRESTAPI.repository;

import com.Apurba.spring.learningRESTAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
