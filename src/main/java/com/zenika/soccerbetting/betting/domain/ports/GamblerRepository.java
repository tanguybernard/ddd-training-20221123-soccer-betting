package com.zenika.soccerbetting.betting.domain.ports;

import com.zenika.soccerbetting.betting.domain.gambler.Gambler;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;

public interface GamblerRepository {


    void save(Gambler gambler);
    Gambler getGamblerById(GamblerId gamblerId);
}
