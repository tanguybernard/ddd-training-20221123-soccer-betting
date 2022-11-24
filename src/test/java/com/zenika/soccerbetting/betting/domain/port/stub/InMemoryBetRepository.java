package com.zenika.soccerbetting.betting.domain.port.stub;

import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.ports.BetRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBetRepository implements BetRepository {

    Map<String, Bet> betArr = new HashMap<>();

    @Override
    public void save(Bet bet) {
        betArr.put(bet.getId().id, bet);
    }

    @Override
    public Bet getBetById(BetId betId) {
        return betArr.get(betId.id);
    }
}
