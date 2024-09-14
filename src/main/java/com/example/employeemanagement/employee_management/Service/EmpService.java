package com.example.employeemanagement.employee_management.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.employee_management.Model.Employee;

@Service
public interface EmpService 
{
    String createEmployee(Employee employee);
    List<Employee> readEmployee();
    boolean deleteEmployee(Long id);
    boolean updateEmployee(Long id, Employee employee);
    Employee readEmployeeById(Long id);
}
