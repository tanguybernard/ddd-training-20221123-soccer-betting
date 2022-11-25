package com.zenika.soccerbetting.betting.domain.match;

import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.shared_kernel.AggregateRoot;

public class Match extends AggregateRoot<MatchId> {


    public Match(MatchId matchId) {
        super(matchId);
    }


    public void cancel(){
        this.record(new MatchCancelled(this.id));
    }
}
