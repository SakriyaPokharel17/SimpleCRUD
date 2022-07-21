package com.example.spring_project_two.Service;


import com.example.spring_project_two.Entity.Student;
import com.example.spring_project_two.Reprositery.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> getStudentList() {
        return studentRepo.findAll();
    }

    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }


}
