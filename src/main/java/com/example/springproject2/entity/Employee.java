package com.example.springproject2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;

}
