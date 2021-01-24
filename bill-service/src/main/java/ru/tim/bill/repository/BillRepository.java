package ru.tim.bill.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tim.bill.entity.Bill;

public interface BillRepository extends CrudRepository<Bill,Long> {
}
