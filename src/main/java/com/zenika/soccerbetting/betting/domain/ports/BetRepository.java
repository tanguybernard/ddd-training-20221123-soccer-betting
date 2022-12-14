package com.zenika.soccerbetting.betting.domain.ports;

import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.match.MatchId;

import java.util.List;

public interface BetRepository {


    void save(Bet bet);
    Bet getBetById(BetId betId);

    List<Bet> getBetsByMatchId(MatchId matchId);
}
