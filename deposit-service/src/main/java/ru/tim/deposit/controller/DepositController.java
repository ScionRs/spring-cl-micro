package ru.tim.deposit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tim.deposit.dto.DepositRequestDTO;
import ru.tim.deposit.dto.DepositResponseDTO;
import ru.tim.deposit.service.DepositService;

@RestController
public class DepositController {

    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/deposits")
    public DepositResponseDTO deposit(@RequestBody DepositRequestDTO requestDTO){
        return depositService.deposit(requestDTO.getAccountId(),requestDTO.getBillId(),requestDTO.getAmount());
    }

}
