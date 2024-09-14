package com.example.employeemanagement.employee_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.employee_management.Model.Employee;
import com.example.employeemanagement.employee_management.Service.EmpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class EmpController 
{
    @Autowired
    EmpService empservice;

    @GetMapping("employees")
    public List<Employee> getAllEmployees()
    {
        return empservice.readEmployee();
    }
    
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee)
    {
        return empservice.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id)
    {
        if(empservice.deleteEmployee(id))
         return "Deleted Succesfully";
         else return "not found";
    }
    
    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if(empservice.updateEmployee(id,employee))
        return "updated Succesfully";
        else  return "not found";
    }

    @GetMapping("employees/{id}")
    public String readEmployeeById(@PathVariable Long id)
    {
        return "Employee =" + empservice.readEmployeeById(id);
    }

}
