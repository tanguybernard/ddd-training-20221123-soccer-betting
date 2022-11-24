package com.zenika.soccerbetting.betting.domain.ports;

import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.validate_bet.ValidateBet;

import java.util.List;

public interface ValidateBetRepository {


    ValidateBet save(ValidateBet validate);
    List<ValidateBet> getByGamblerId(GamblerId gamblerId);

}
