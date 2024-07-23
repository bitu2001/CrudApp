package com.crud.service;

import com.crud.model.Employee;
import com.crud.repository.EmployyeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployyeRepo repository;

    public ResponseEntity<?> createEmployee(Employee newEmployee) {
        Optional<Employee> existEmployee = repository.findByEmail(newEmployee.getEmail());
        if(existEmployee.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee Already Registerd");
        }
        else{
            repository.save(newEmployee);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee Created SucessFully");
        }
    }

    public ResponseEntity<?> getAllEmployee() {
        List<Employee> allEmployee=repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allEmployee);
    }

    public ResponseEntity<?> getEmployeeById(Long id) {
        Optional<Employee> employee=repository.findById(id);
        if (employee.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(employee.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found");
        }
    }

    public ResponseEntity<?> deleteEmployeeById(Long id) {
        Optional<Employee> employee=repository.findById(id);
        if(employee.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found");
        }
    }

    public ResponseEntity<?> updateEmployee(Long id, Employee employee) {
        Optional<Employee> getemployee=repository.findById(id);
        if(getemployee.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user Found");
        }
        else {
            Employee newEmployee=getemployee.get();
            newEmployee.setFullname(employee.getFullname());
            newEmployee.setEmail(employee.getEmail());
            newEmployee.setPassword(employee.getPassword());
            repository.save(newEmployee);
            return ResponseEntity.status(HttpStatus.OK).body("User updated");
        }
    }
}
