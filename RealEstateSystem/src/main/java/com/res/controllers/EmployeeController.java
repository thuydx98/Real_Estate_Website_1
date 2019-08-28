package com.res.controllers;

import com.res.models.Account;
import com.res.models.Employee;
import com.res.services.AccountService;
import com.res.services.EmployeeService;
import com.res.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private NotificationService notifyService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AccountService accountService;



    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String viewEmp(Model model) {
        List<Employee> lstemp = employeeService.findAll();
        model.addAttribute("lstemp", lstemp);
        return "employees/ViewEmp";
    }
    @RequestMapping(value = "/employee/edit/{id}", method= RequestMethod.GET)
    public String edit(@PathVariable int id, Model model) {
        Employee employee = employeeService.getCusByID(id);
        model.addAttribute("employee", employee);
        return "employees/EditEmp";
    }
    @RequestMapping(value = "/employee/edit/{id}", method= RequestMethod.POST)
    public String edit(@PathVariable Integer id, @ModelAttribute("employee") Employee employee) {
        Employee emp = this.employeeService.getCusByID(id);
        emp.setFullname(employee.getFullname());
        emp.setAddress(employee.getAddress());
        emp.setEmail(employee.getEmail());
        emp.setIdNumber(employee.getIdNumber());
        emp.setPhoneNumber(employee.getPhoneNumber());
        emp.getAccount().setUserName(employee.getAccount().getUserName());
        employeeService.createOrUpdate(emp);
        return "employees/EditEmp";
    }
    @RequestMapping(value = "/employee/search", method= RequestMethod.GET)
    public String search(String name, Model model) {
        List<Employee> employees = employeeService.findByName(name);
        model.addAttribute("lstemp", employees);
        return "employees/ViewEmp";
    }

    @RequestMapping(value = "/employees/create", method = RequestMethod.GET)
    public String create(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/AddEmp";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String create(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
        Account acc = new Account();
        acc.setUserName(employee.getAccount().getUserName());
        acc.setPassword(employee.getAccount().getPassword());
        accountService.createOrUpdate(acc);
        employee.setAccount(acc);
        acc.setEmployee(employee);
        employeeService.createOrUpdate(employee);
        redirect.addFlashAttribute("Done.", "Saved customer success!");
        return "employees/AddEmp";
    }
}
