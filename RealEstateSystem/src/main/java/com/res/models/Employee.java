package com.res.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_ID;

    @Column(nullable = false, length = 100)
    private String fullname;

    @Column(nullable = true)
    private int idNumber;

    @Column(nullable = true)
    private int phoneNumber;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 200)
    private String address;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Employee manager;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Account account;

    @OneToMany(mappedBy = "manager")
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "censor")
    private Set<ReportedPost> censorshipPosts = new HashSet<>();

    public int getEmployee_ID() {
        return employee_ID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<ReportedPost> getCensorshipPosts() {
        return censorshipPosts;
    }

    public void setCensorshipPosts(Set<ReportedPost> censorshipPosts) {
        this.censorshipPosts = censorshipPosts;
    }

    public Employee() {
    }
}
