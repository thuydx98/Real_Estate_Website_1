package com.res.services;
import com.res.models.Account;
import com.res.models.AccountRole;
import com.res.models.Customer;
import com.res.models.Employee;
import com.res.repositories.AccountRepository;
import com.res.repositories.AccountRoleRepository;
import com.res.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountRoleServicelmpl implements AccountRoleService {
    @Autowired
    private AccountRoleRepository accountRoleRepo;
    @Override
    public AccountRole createOrUpdate(AccountRole accountRole)
    {
        return this.accountRoleRepo.save(accountRole);
    }
}
