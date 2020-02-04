package com.app.rewards.services.impl;

import com.app.rewards.services.RewardsService;
import org.springframework.stereotype.Service;

@Service
public class RewardsServiceImpl implements RewardsService {

    @Override
    public int getRewards(int expenditure) {
        return calculateRewards(expenditure);
    }

    private int calculateRewards(int expenditure) {
        int rewards = 0;

        if (expenditure >= 100) {
            rewards = getActualRewards(expenditure);
        }

        return rewards;
    }

    private int getActualRewards(int expenditure) {
        int rewards = getDifferenceToHundred(expenditure) * 2;
        int numberOfFifties = getNumberOfFifties(expenditure);
        rewards = rewards + (numberOfFifties * 50);
        return rewards;
    }

    private int getNumberOfFifties(int expenditure) {
        return (int) (Math.floor(expenditure/50.0) - 1);
    }

    private int getDifferenceToHundred(int expenditure) {
        return expenditure - 100;
    }
}
