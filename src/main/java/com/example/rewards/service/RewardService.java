
package com.example.rewards.service;

import com.example.rewards.dto.MonthlyReward;
import com.example.rewards.dto.RewardResponse;
import com.example.rewards.entity.Transaction;
import com.example.rewards.exception.CustomerNotFoundException;
import com.example.rewards.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RewardService {

    private final TransactionRepository transactionRepository;

    public RewardService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<RewardResponse> getRewards() {

        List<Transaction> transactions = transactionRepository.getTransactions();

        Map<Long, List<Transaction>> customerTransactions = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCustomerId));

        return customerTransactions.entrySet().stream()
                .map(entry -> buildRewardResponse(entry.getKey(), entry.getValue()))
                .toList();
    }

    public RewardResponse getRewardsByCustomerId(Long customerId) {

        List<Transaction> transactions = transactionRepository.getTransactions()
                .stream()
                .filter(transaction -> transaction.getCustomerId().equals(customerId))
                .toList();

        if (transactions.isEmpty()) {
            throw new CustomerNotFoundException(
                    "Customer not found with id: " + customerId);
        }

        return buildRewardResponse(customerId, transactions);
    }

    private RewardResponse buildRewardResponse(Long customerId,
                                               List<Transaction> transactions) {

        String customerName = transactions.getFirst().getCustomerName();

        Map<String, Long> monthlyRewards = transactions.stream()
                .collect(Collectors.groupingBy(
                        transaction -> transaction.getTransactionDate()
                                .getMonth()
                                .getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                        Collectors.summingLong(
                                transaction -> calculateRewardPoints(
                                        transaction.getAmount()))
                ));

        List<MonthlyReward> monthlyRewardList = monthlyRewards.entrySet()
                .stream()
                .map(entry -> new MonthlyReward(entry.getKey(), entry.getValue()))
                .toList();

        long totalRewards = monthlyRewardList.stream()
                .mapToLong(MonthlyReward::getPoints)
                .sum();

        return new RewardResponse(
                customerId,
                customerName,
                monthlyRewardList,
                totalRewards
        );
    }

    public long calculateRewardPoints(Double amount) {

        if (amount == null || amount < 0) {
            throw new IllegalArgumentException(
                    "Transaction amount cannot be null or negative");
        }

        long points = 0;

        if (amount > 100) {
            points += (long) ((amount - 100) * 2);
            points += 50;
        } else if (amount > 50) {
            points += (long) (amount - 50);
        }

        return points;
    }
}
