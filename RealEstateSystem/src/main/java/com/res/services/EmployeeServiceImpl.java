package com.res.services;

import com.res.models.AccountRole;
import com.res.models.Customer;
import com.res.models.Employee;
import com.res.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Query;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;
    @Autowired
    private EntityManager entityManager;

    @Override
    public int totalEmployees() {
        return this.employeeRepo.findAll().size();
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepo.findAll();
    }

    @Override
    public List<Employee> findByName(String name) {
        return this.employeeRepo.findAll().stream().filter(p -> p.getFullname().contains(name)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByUsername(String username) {
        return this.employeeRepo.findAll().stream().filter(p -> p.getAccount().getUserName().contains(username)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByEmail(String email) {
        return (List<Employee>) this.employeeRepo.findAll().stream().filter(p -> p.getEmail().contains(email));
    }

    @Override
    public boolean createOrUpdate(Employee employee) {
        try {
            this.employeeRepo.save(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public Employee getCusByID(int id) {
        return employeeRepo.findOne(id);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) {
//
//        employees employee = this.employeeRepo.findAll().stream().filter(p -> Objects.equals(p.getAccount().getUserName(), username)).findFirst()
//                .orElse(null);
//
//        if (employee == null) {
//            System.out.println("Account not found! " + username);
//            throw new UsernameNotFoundException("Account " + username + " was not found in the database");
//        }
//
//        System.out.println("Found employees: " + employee);
//
//        List<String> roleNames = this.employeeRepo.getRoleNames(employee.getAccount().getAccountId());
//
//        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        if (roleNames != null) {
//            for (String role : roleNames) {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority(role);
//                grantList.add(authority);
//            }
//        }
//
//        UserDetails userDetails = (UserDetails) new User(employee.getAccount().getUserName(),
//                employee.getAccount().getPassword(), grantList);
//
//        return userDetails;
//    }

    @Override
    public List<String> getRoleNames(int account_ID) {
        String sql = "Select ur.role.roleName from " + AccountRole.class.getName() + " ur " //
                + " where ur.account.accountId = :account_ID ";

        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("account_ID", account_ID);
        return query.getResultList();
    }
}
