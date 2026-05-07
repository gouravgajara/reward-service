
package com.example.rewards.dto;

import java.util.List;

public class RewardResponse {

    private Long customerId;
    private String customerName;
    private List<MonthlyReward> monthlyRewards;
    private long totalRewards;

    public RewardResponse(Long customerId, String customerName,
                          List<MonthlyReward> monthlyRewards,
                          long totalRewards) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.monthlyRewards = monthlyRewards;
        this.totalRewards = totalRewards;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<MonthlyReward> getMonthlyRewards() {
        return monthlyRewards;
    }

    public long getTotalRewards() {
        return totalRewards;
    }
}
