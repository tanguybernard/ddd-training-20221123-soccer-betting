package com.zenika.soccerbetting.betting.ports;

import com.zenika.soccerbetting.betting.domain.gambler.Gambler;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.ports.GamblerRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryGamblerRepository implements GamblerRepository {

    Map<String, Gambler> gamblers = new HashMap<>();

    @Override
    public void save(Gambler g) {
        gamblers.put(g.getId().value, g);
    }

    @Override
    public Gambler getGamblerById(GamblerId gamblerId) {
        return gamblers.get(gamblerId.value);
    }


}
