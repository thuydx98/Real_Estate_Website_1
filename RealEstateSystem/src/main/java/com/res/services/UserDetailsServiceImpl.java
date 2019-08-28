package com.res.services;

import com.res.models.Employee;
import com.res.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Employee employee = this.employeeService.findAll().stream().filter(p -> Objects.equals(p.getAccount().getUserName(), userName)).findFirst()
                .orElse(null);

        if (employee == null) {
            System.out.println("Account not found! " + userName);
            throw new UsernameNotFoundException("Account " + userName + " was not found in the database");
        }

        System.out.println("Found employees: " + employee);

        List<String> roleNames = this.employeeService.getRoleNames(employee.getAccount().getAccountId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(employee.getAccount().getUserName(),
                employee.getAccount().getPassword(), grantList);

        return userDetails;
    }

}