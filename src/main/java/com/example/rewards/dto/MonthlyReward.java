
package com.example.rewards.dto;

public class MonthlyReward {

    private String month;
    private long points;

    public MonthlyReward(String month, long points) {
        this.month = month;
        this.points = points;
    }

    public String getMonth() {
        return month;
    }

    public long getPoints() {
        return points;
    }
}
