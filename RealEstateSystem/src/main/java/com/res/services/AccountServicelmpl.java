package com.res.services;
import com.res.models.Account;
import com.res.models.Customer;
import com.res.models.Employee;
import com.res.repositories.AccountRepository;
import com.res.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountServicelmpl implements AccountService {
    @Autowired
    private AccountRepository accountRepo;
    @Override
    public Account createOrUpdate(Account account)
    {
        return this.accountRepo.save(account);
    }
}
