package com.genuinecoder.SpringServer.model.employee;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> { // <> = <Key, Value> of the repository

  // @Query("SELECT s FROM employee s WHERE s.name = ?1")
  // Optional<Employee> findEmployeeByName(String name);

  
}
