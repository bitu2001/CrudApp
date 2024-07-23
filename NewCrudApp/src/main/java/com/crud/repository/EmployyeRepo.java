package com.crud.repository;

import com.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployyeRepo extends JpaRepository <Employee,Long>{
    Optional<Employee> findByEmail(String email);
}
