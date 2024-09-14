package com.example.employeemanagement.employee_management.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.employee_management.Entity.EmployeeEntity;
import com.example.employeemanagement.employee_management.Model.Employee;
import com.example.employeemanagement.employee_management.Repository.EmployeeRepository;

@Service
public class EmpServiceImpl implements EmpService
 {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee)
     {
        EmployeeEntity employeeEntity= new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        
        employeeRepository.save(employeeEntity);

        return "Saved Succesfully";

    }

    @Override
    public List<Employee> readEmployee() {
        List<EmployeeEntity> employeeList=employeeRepository.findAll();
        List<Employee> employees=new ArrayList<>();

        for (EmployeeEntity employeeEntity :employeeList)
        {
            Employee emp= new Employee();

            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            emp.setId(employeeEntity.getId());

            employees.add(emp);

        }

        return employees;

    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public boolean updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();

        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());

        employeeRepository.save(existingEmployee);
        return true;

    }

    @Override
    public Employee readEmployeeById(Long id) {
        EmployeeEntity emp=employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(emp, employee);

        return employee;
    }
}
