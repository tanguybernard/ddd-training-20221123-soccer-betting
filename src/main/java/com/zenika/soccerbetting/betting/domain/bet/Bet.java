package com.zenika.soccerbetting.betting.domain.bet;

import com.zenika.soccerbetting.betting.domain.match.MatchId;
import com.zenika.soccerbetting.shared_kernel.AggregateRoot;

public class Bet extends AggregateRoot<BetId> {

    public MatchId matchId;
    public String type;

    public Bet(BetId betId, MatchId matchId, String type) {
        super(betId);
        this.matchId = matchId;
        this.type = type;
    }
}
