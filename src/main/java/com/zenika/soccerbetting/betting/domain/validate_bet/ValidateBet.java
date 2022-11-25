package com.zenika.soccerbetting.betting.domain.validate_bet;

import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.shared_kernel.AggregateRoot;

public class ValidateBet extends AggregateRoot<ValidateBetId> {


    private ValidateBetId id;
    public BetId betId;
    private GamblerId gamblerId;
    public Status status;

    public String type;

    public ValidateBet(ValidateBetId id, BetId betId, GamblerId gamblerId, Status status){
        super(id);

        this.id = id;
        this.betId = betId;
        this.gamblerId = gamblerId;
        this.status = status;
    }

    static ValidateBet create(ValidateBetId id, BetId betId, GamblerId gamblerId, Status status) {



        return new ValidateBet(id, betId, gamblerId, status);
    }


    public GamblerId getGamblerId() {
        return this.gamblerId;
    }

    public void cancel() {

    }

}
