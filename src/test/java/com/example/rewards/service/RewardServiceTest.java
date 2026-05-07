
package com.example.rewards.service;

import com.example.rewards.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RewardServiceTest {

    private RewardService rewardService;

    @BeforeEach
    void setup() {
        rewardService = new RewardService(new TransactionRepository());
    }

    @Test
    void shouldCalculateRewardPointsCorrectly() {

        long points = rewardService.calculateRewardPoints(120.0);

        Assertions.assertEquals(90, points);
    }

    @Test
    void shouldReturnZeroRewardsForAmountBelow50() {

        long points = rewardService.calculateRewardPoints(40.0);

        Assertions.assertEquals(0, points);
    }

    @Test
    void shouldThrowExceptionForNegativeAmount() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> rewardService.calculateRewardPoints(-10.0)
        );
    }
}
