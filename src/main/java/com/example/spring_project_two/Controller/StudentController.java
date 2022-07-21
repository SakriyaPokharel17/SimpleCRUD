package com.example.spring_project_two.Controller;

import com.example.spring_project_two.Entity.Student;
import com.example.spring_project_two.SecurityConfig.SecurityConfig;
import com.example.spring_project_two.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RequestMapping("/api")
@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String homePage(Model model) {
        List<Student> stdList = studentService.getStudentList();
        model.addAttribute("ListOfStudents", stdList);
        return "index";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new";
    }

    @RequestMapping("/delete/{sts_id}")
    public String deleteStudent(@PathVariable(name = "sts_id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{sts_id}")
    public ModelAndView editStudent(@PathVariable(name = "sts_id") int id) {
        ModelAndView modelAndView = new ModelAndView("new");
        Student student = studentService.getStudentById(id);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student) {

        String password = student.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(password);
        student.setPassword(encodePassword);
        studentService.saveStudent(student);
        return "redirect:/";
    }

}
