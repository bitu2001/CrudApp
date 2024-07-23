package com.crud.controller;

import com.crud.model.Employee;
import com.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Employee newEmployee){
            return service.createEmployee(newEmployee);
    }
    @GetMapping("/getAllEmployee")
    public ResponseEntity<?> getEmployee(){
        return service.getAllEmployee();
    }
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        return service.getEmployeeById(id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        return service.deleteEmployeeById(id);
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id ,@RequestBody Employee employee){
        return service.updateEmployee(id,employee);
    }

}
