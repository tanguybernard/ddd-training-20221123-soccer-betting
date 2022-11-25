package com.zenika.soccerbetting.betting.domain.match;

import com.zenika.soccerbetting.shared_kernel.AggregateRoot;
import com.zenika.soccerbetting.shared_kernel.domain_event.DomainEvent;

import java.util.Date;

public class MatchCancelled implements DomainEvent{

    Date occurredOn;
    String eventName;
    public MatchId matchId;

    public MatchCancelled(MatchId matchId) {
        this.matchId = matchId;
        this.occurredOn = new Date();
        this.eventName = MatchCancelled.class.getName();
    }
}
