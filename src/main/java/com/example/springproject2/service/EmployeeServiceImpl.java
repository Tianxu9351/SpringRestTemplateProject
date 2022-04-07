package com.example.springproject2.service;

import com.example.springproject2.entity.Employee;
import com.example.springproject2.entity.EmployeeDTO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@Transactional
public class EmployeeServiceImpl {


    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public EmployeeServiceImpl (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    private final String url = "http://dummy.restapiexample.com/api/v1/employees";

    public List<EmployeeDTO> getAllEmployee() {
//        ResponseEntity<List<Employee>> result = restTemplateBuilder.build().
//                exchange(url,
//                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});
//        List<Employee> empList = new ArrayList<>();
//        empList.addAll(result.getBody());
//        empList.stream().collect(groupingBy(Employee::getEmployee_age));
//        return empList;
        Map<Integer, List<EmployeeDTO>> uriParameter = new HashMap<>();
        RestTemplate client= restTemplateBuilder.build();
        EmployeeDTO[] employeeDTO = client.getForObject(url, EmployeeDTO[].class);

        uriParameter  = Arrays.asList(employeeDTO).stream().collect(groupingBy(EmployeeDTO::getEmployee_age));

        return uriParameter.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

//    public List<Employee> getEmployeeByAge(int employee_age) {
//
//    }

}
