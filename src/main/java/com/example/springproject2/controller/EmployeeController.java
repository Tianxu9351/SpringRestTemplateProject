package com.example.springproject2.controller;

import com.example.springproject2.entity.Employee;
import com.example.springproject2.entity.EmployeeDTO;
import com.example.springproject2.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> list = employeeServiceImpl.getAllEmployee();
        return new ResponseEntity<List<EmployeeDTO>>(list, HttpStatus.OK);
    }
//
//    @GetMapping("employees/{age}")
//    public ResponseEntity<List<EmployeeDTO>> getEmployeeByAge(@PathVariable("age") Integer employee_age) {
//       List<Employee> list = employeeServiceImpl.getEmployeeByAge(employee_age);
//        return new ResponseEntity<List<EmployeeDTO>>(list, HttpStatus.OK);
//    }
}
