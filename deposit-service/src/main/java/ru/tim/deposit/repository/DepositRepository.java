package ru.tim.deposit.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tim.deposit.entity.Deposit;

public interface DepositRepository extends CrudRepository<Deposit,Long> {
}
