package com.res.services;

import com.res.models.Customer;
import com.res.models.Employee;
import com.res.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public int totalCustomers() {
        return this.customerRepo.findAll().size();
    }

    @Override
    public int totalCustomersByYear(int year) {
        Calendar cal = Calendar.getInstance();
        List<Customer> customers = this.customerRepo.findAll();

        int i = 0;
        for (Customer cus : customers) {

            cal.setTime(cus.getCreateDate());

            if (cal.get(Calendar.YEAR) == year) {
                i++;
            }
        }

        return i;
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }

//    @Override
//    public List<Customer> findByName(String name) {
//        return customerRepo.findByName(name);
//   }
//
   @Override
   public List<Customer> findByName(String name) {
       return this.customerRepo.findAll().stream().filter(p -> p.getFullname().contains(name)).collect(Collectors.toList());
    }


    @Override
    public List<Customer> findByUsername(String username) {
        return this.customerRepo.findAll().stream().filter(p -> p.getAccount().getUserName().contains(username)).collect(Collectors.toList());
    }

    @Override
    public Customer createOrUpdate(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer getCusByID(int id) {
        return customerRepo.findOne(id);
    }
//    @Override
//    public boolean createOrUpdate(Customer customer) {
//        try {
//            this.customerRepo.save(customer);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
}
