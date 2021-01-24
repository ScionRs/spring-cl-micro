package ru.tim.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tim.account.entity.Account;
import ru.tim.account.exception.AccountNotFoundException;
import ru.tim.account.repository.AccountRepository;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account getAccountById(Long accountId){
        return accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Unable to find account with id: " + accountId));
    }

    public Long createAccount(String name, String email, String phone, List<Long> bills){
        Account account = new Account(name,email,phone,OffsetDateTime.now(),bills);
        return accountRepository.save(account).getAccountID();
    }

    public Account updateAccount(Long accountId,String name, String email, String phone, List<Long> bills){
        Account account = new Account();
        account.setAccountID(accountId);
        account.setBills(bills);
        account.setEmail(email);
        account.setPhone(phone);
        account.setName(name);
        return accountRepository.save(account);
    }

    public Account deleteAccount(Long accountId){
        Account deleteAccount = getAccountById(accountId);
        accountRepository.deleteById(accountId);
        return deleteAccount;
    }

}

