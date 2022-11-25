package com.zenika.soccerbetting.betting.domain.ports;

import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.match.Match;
import com.zenika.soccerbetting.betting.domain.match.MatchId;

public interface MatchRepository {

    void save(Match match);
    Match getMatchById(MatchId matchId);
}
