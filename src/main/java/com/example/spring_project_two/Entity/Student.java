package com.example.spring_project_two.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "thymeleaf_project")
@Entity
public class Student {
    @GeneratedValue
    @Id
    private int std_id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "")
    private String lastName;
    private String password;
}
