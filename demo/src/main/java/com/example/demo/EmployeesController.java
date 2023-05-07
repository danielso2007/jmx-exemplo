package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeesController {

    private static final Logger log = LoggerFactory.getLogger(EmployeesController.class);

    @GetMapping("/employees")
    List<Employee> all() {
      List<Employee> list = new ArrayList<>();
      list.add(new Employee(1L,"Daniel", "Admin"));
      list.add(new Employee(323L,"Denis", "Admin"));
      list.add(new Employee(654L,"Danilo", "Admin"));
      log.info("Listando...");
      return list;
    }
  
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
      log.info("Obter employee...");
      return newEmployee;
    }
  
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
      Employee newEmployee = new Employee("Daniel", "Admin");
      log.info("Update employee...");
      return newEmployee;
    }
  
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
      log.info("Obter employee pelo id {}...", id);
      return newEmployee;
    }
  
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
      log.info("Deletando employee id {}...", id);
    }
  }