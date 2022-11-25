package com.zenika.soccerbetting.betting.ports.stubs;

import com.zenika.soccerbetting.betting.domain.match.Match;
import com.zenika.soccerbetting.betting.domain.match.MatchId;
import com.zenika.soccerbetting.betting.domain.ports.MatchRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMatchRepository implements MatchRepository {

    Map<String, Match> matchMap = new HashMap<>();

    @Override
    public void save(Match match) {
        matchMap.put(match.getId().id, match);
    }

    @Override
    public Match getMatchById(MatchId matchId) {
        return  matchMap.get(matchId.id);
    }
}
