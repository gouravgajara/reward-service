
package com.example.rewards.entity;

import java.time.LocalDate;

public class Transaction {

    private Long transactionId;
    private Long customerId;
    private String customerName;
    private Double amount;
    private LocalDate transactionDate;

    public Transaction(Long transactionId, Long customerId, String customerName,
                       Double amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}
