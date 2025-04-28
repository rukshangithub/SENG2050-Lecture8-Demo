package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;


    public Department savDepartment(Department department)
    {
        return departmentRepository.save(department);
    }


}
