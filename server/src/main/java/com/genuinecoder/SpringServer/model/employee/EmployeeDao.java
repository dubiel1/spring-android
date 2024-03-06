// Dao == Data Access Object
package com.genuinecoder.SpringServer.model.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeDao {

  @Autowired
  private EmployeeRepository repository;

  // method can work also by return void, but for better UX we return the saved object to the user, including the id, which is auto generated
  public Employee save(Employee employee) {
      return repository.save(employee);
  }
  

  public List<Employee> getAllEmployees() {
    List<Employee> employees = new ArrayList<>();
    Streamable.of(repository.findAll()).forEach(employees::add);
    return employees;
  }

  public void delete(Employee employee) {
    repository.delete(employee);
  }

  public Employee findEmployeeById(Integer id) {
    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with the given ID."));
  }

}
