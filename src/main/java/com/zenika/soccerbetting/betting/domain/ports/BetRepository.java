package com.zenika.soccerbetting.betting.domain.ports;

import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;

public interface BetRepository {


    void save(Bet bet);
    Bet getBetById(BetId betId);
}
