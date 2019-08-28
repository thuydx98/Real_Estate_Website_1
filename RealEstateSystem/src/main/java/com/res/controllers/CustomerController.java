package com.res.controllers;

import com.res.models.Account;
import com.res.models.AccountRole;
import com.res.models.Customer;
import com.res.models.Role;
import com.res.services.AccountService;
import com.res.services.CustomerService;
import com.res.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {


    @Autowired
    private NotificationService notifyService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String index(Model model){
        List<Customer> lstCus = customerService.findAll();
        model.addAttribute("lstCus",lstCus);
        return "customers/IndexCustomer";
    }
    @RequestMapping(value = "/customers/create", method = RequestMethod.GET)
    public String create(Model model) {
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "customers/AddCustomer";
    }
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String create(@Valid Customer customer, BindingResult result, RedirectAttributes redirect) {
        Account acc=new Account();
        acc.setUserName(customer.getAccount().getUserName());
        acc.setPassword(customer.getAccount().getPassword());
        accountService.createOrUpdate(acc);
        customer.setAccount(acc);
        acc.setCustomer(customer);
//        AccountRole accrole = new AccountRole();
//        accrole.setRole(accrole.getRole());
//        acc.setAccountRoles(accrole);
        Customer cus =customerService.createOrUpdate(customer);
        return "customers/AddCustomer";
    }
    @RequestMapping(value = "/customer/edit/{id}", method= RequestMethod.GET)
    public String edit(@PathVariable int id, Model model) {
        Customer customer = customerService.getCusByID(id);
        model.addAttribute("customer", customer);
        return "customers/EditCustomer";
    }
    @RequestMapping(value = "/customer/edit/{id}", method= RequestMethod.POST)
    public String edit(@PathVariable Integer id, @ModelAttribute("customer") Customer customer) {
        Customer cus = this.customerService.getCusByID(id);
        cus.setFullname(customer.getFullname());
        cus.setAddress(customer.getAddress());
        cus.setEmail(customer.getEmail());
        cus.getAccount().setUserName(customer.getAccount().getUserName());
        customerService.createOrUpdate(cus);
        return "customers/EditCustomer";
    }
    @RequestMapping(value = "/customer/search", method= RequestMethod.GET)
    public String search(String name, Model model) {
        List<Customer> customer = customerService.findByName(name);
        model.addAttribute("lstCus", customer);
        return "customers/IndexCustomer";
    }
}
