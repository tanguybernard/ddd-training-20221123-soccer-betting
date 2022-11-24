package com.zenika.soccerbetting.betting.domain.gambler;

import com.zenika.soccerbetting.shared_kernel.AggregateRoot;

public class Gambler extends AggregateRoot<GamblerId> {
    public Gambler(GamblerId gamblerId) {
        super(gamblerId);
    }

}
