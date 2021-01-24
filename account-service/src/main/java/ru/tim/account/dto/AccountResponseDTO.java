package ru.tim.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.tim.account.entity.Account;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class AccountResponseDTO {
    public Long accountID;

    private String name;

    private String email;

    private String phone;

    private List<Long> bills;

    private OffsetDateTime creationDate;

    public AccountResponseDTO(Account account){
        accountID = account.getAccountID();
        name = account.getName();
        email = account.getEmail();
        phone = account.getPhone();
        bills = account.getBills();
        creationDate = account.getCreationDate();
    }
}
