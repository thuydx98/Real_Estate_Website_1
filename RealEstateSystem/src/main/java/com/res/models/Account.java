package com.res.models;

import com.res.utils.EncrytedPasswordUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "Account_UK", columnNames = "Username") })
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "AccountID", nullable = false)
    private int accountId;

    @Column(name = "Username", length = 36, nullable = false)
    private String userName;

    @Column(name = "Password", length = 128, nullable = false)
    private String password ;

    @Column(name = "Enabled", length = 1, nullable = true)
    private boolean enabled;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    //@JoinColumn(name = "account")
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "account")
    private Employee employee;

    @OneToMany(mappedBy = "account")
    private Set<AccountRole> accountRoles = new HashSet<>();

    public int getAccountId() {
        return accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = EncrytedPasswordUtils.encrytePassword(password);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(Set<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }

    public Account() {
    }
}
