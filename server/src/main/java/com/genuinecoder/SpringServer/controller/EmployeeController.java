package com.genuinecoder.SpringServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.genuinecoder.SpringServer.model.employee.Employee;
import com.genuinecoder.SpringServer.model.employee.EmployeeDao;


// @ControllerAdvice
@RestController
public class EmployeeController {

  @Autowired
  private EmployeeDao employeeDao;

  @GetMapping("/employee/get-all")
  public List<Employee> getAllEmployees() {
    return employeeDao.getAllEmployees();
  }
  
  @PostMapping("/employee/save")
  public ResponseEntity<Employee> save(@RequestBody Employee employee) {
    try{
      Employee result = employeeDao.save(employee);
      System.out.println(result);
      return new ResponseEntity<>(result, HttpStatus.OK);   // Code 200

    }
    catch (Exception ex) {
      System.out.println("DUBI");
      System.out.println(ex);
      return new ResponseEntity<>(null, HttpStatus.CONFLICT);   // Code 409
    }
  
  }
  
}
