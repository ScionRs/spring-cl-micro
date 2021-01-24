package ru.tim.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.tim.account.dto.AccountRequestDTO;
import ru.tim.account.dto.AccountResponseDTO;
import ru.tim.account.service.AccountService;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}")
    public AccountResponseDTO getAccount(@PathVariable Long accountId){
        return  new AccountResponseDTO(accountService.getAccountById(accountId));
    }

    @PostMapping("/")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO){
        return accountService.createAccount(accountRequestDTO.getName(),accountRequestDTO.getEmail(),accountRequestDTO.getPhone(),accountRequestDTO.getBills());
    }

    @PutMapping("/{accountId}")
    public AccountResponseDTO updateAccount(@PathVariable Long accountId, @RequestBody AccountRequestDTO accountRequestDTO){
        return new AccountResponseDTO(accountService.updateAccount(accountId,accountRequestDTO.getName(),accountRequestDTO.getEmail(),accountRequestDTO.getPhone(),accountRequestDTO.getBills()));
    }

    @DeleteMapping("/{accountId}")
    public AccountResponseDTO deleteAccount(@PathVariable Long accountId){
        return  new AccountResponseDTO(accountService.deleteAccount(accountId));
    }
}
