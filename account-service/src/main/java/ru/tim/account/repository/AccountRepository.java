package ru.tim.account.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tim.account.entity.Account;

public interface AccountRepository extends CrudRepository<Account,Long> {


}
