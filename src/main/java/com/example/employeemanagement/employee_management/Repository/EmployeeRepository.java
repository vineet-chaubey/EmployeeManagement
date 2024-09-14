package com.example.employeemanagement.employee_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanagement.employee_management.Entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
