package com.example.spring_project_two.Reprositery;

import com.example.spring_project_two.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
