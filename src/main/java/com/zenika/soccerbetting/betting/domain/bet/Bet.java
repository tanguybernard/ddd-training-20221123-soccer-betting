package com.zenika.soccerbetting.betting.domain.bet;

import com.zenika.soccerbetting.betting.domain.validate_bet.ValidateBetId;
import com.zenika.soccerbetting.shared_kernel.AggregateRoot;

public class Bet extends AggregateRoot<BetId> {

    public String type;

    public Bet(BetId betId, String type) {
        super(betId);
        this.type = type;
    }
}
