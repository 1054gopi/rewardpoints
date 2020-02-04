package com.app.rewards.controllers;

import com.app.rewards.models.Expenditure;
import com.app.rewards.response.RewardsResponse;
import com.app.rewards.services.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RewardsControllers {

    final RewardsService rewardsService;

    @Autowired
    public RewardsControllers(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @RequestMapping(value = "/getRewardPoints", method = RequestMethod.POST)
    public List<RewardsResponse> getRewardPoints(@RequestBody List<Expenditure> expenditureList) {
        return expenditureList.stream()
                .map(expenditure ->
                        RewardsResponse.builder()
                            .expenditure(expenditure.getExpenditure())
                            .rewards(rewardsService.getRewards(expenditure.getExpenditure()))
                            .build())
                .collect(Collectors.toList());
    }
}
