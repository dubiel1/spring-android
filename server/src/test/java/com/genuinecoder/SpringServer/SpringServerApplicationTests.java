package com.genuinecoder.SpringServer;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.genuinecoder.SpringServer.model.employee.Employee;
import com.genuinecoder.SpringServer.model.employee.EmployeeDao;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private EmployeeDao employeeDao;

	// @Test
	void addEmployeeTest() throws Exception {
		Employee employee = new Employee();
		employee.setName("Brian L");
		employee.setLocation("Dublin");
		employee.setBranch("IT");
		
		employeeDao.save(employee);

		// Add unique constraint on the database that prevents two identical name + location added. Use stored procedures
	}

	// @Test
	void getAllEmployees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		System.out.println(employees);
	}

	// @Test
	void getAllEmployeesAndDeleteThem() {
		List<Employee> employees = employeeDao.getAllEmployees();
		for (Employee employee : employees) {
			employeeDao.delete(employee);
		}
	}

	@Test
	void findEmployeeById() {
		Integer id = 1;
		Employee employeeOptional = employeeDao.findEmployeeById(id);
		if (employeeOptional != null) {
			System.out.println(employeeOptional.getName());
		} 
		// employeeOptional.ifPresent(empl -> System.out.println(empl.getName()));
	}

}
