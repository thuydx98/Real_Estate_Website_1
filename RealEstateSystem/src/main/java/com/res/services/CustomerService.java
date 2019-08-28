package com.res.services;

import com.res.models.Customer;

import java.util.List;

public interface CustomerService {

    int totalCustomers();

    int totalCustomersByYear(int year);

    List<Customer> findAll();

    List<Customer> findByName(String name);

    List<Customer> findByUsername(String username);

    Customer createOrUpdate(Customer customer);

    Customer getCusByID(int id);
}
