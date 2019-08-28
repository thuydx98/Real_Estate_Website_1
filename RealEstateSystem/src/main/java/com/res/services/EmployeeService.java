package com.res.services;

import com.res.models.Customer;
import com.res.models.Employee;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface EmployeeService {

    int totalEmployees();

    List<Employee> findAll();

    List<Employee> findByName(String name);

    List<Employee> findByUsername(String username);

    List<Employee> findByEmail(String email);

    boolean createOrUpdate(Employee employee);

    List<String> getRoleNames(int account_ID);

    Employee getCusByID(int id);
}
