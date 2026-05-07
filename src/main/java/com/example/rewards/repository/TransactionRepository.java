
package com.example.rewards.repository;

import com.example.rewards.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionRepository {

    public List<Transaction> getTransactions() {
        return List.of(
                new Transaction(1L, 101L, "John", 120.0, LocalDate.now().minusMonths(2)),
                new Transaction(2L, 101L, "John", 75.0, LocalDate.now().minusMonths(1)),
                new Transaction(3L, 101L, "John", 200.0, LocalDate.now()),

                new Transaction(4L, 102L, "Smith", 45.0, LocalDate.now().minusMonths(2)),
                new Transaction(5L, 102L, "Smith", 95.0, LocalDate.now().minusMonths(1)),
                new Transaction(6L, 102L, "Smith", 130.0, LocalDate.now()),

                new Transaction(7L, 103L, "David", 150.0, LocalDate.now().minusMonths(2)),
                new Transaction(8L, 103L, "David", 220.0, LocalDate.now().minusMonths(1)),
                new Transaction(9L, 103L, "David", 60.0, LocalDate.now())
        );
    }
}
