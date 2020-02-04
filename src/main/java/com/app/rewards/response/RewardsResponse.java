package com.app.rewards.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RewardsResponse {
    int expenditure;
    int rewards;
}
