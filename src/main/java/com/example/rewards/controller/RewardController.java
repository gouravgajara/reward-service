
package com.example.rewards.controller;

import com.example.rewards.dto.RewardResponse;
import com.example.rewards.service.RewardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public List<RewardResponse> getAllRewards() {
        return rewardService.getRewards();
    }

    @GetMapping("/{customerId}")
    public RewardResponse getRewardByCustomerId(
            @PathVariable Long customerId) {

        return rewardService.getRewardsByCustomerId(customerId);
    }
}
