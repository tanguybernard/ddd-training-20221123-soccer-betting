package com.zenika.soccerbetting.betting.ports.stubs;

import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.ports.ValidateBetRepository;
import com.zenika.soccerbetting.betting.domain.validate_bet.ValidateBet;
import com.zenika.soccerbetting.betting.domain.validate_bet.ValidateBetId;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryValidateBetRepository implements ValidateBetRepository {

    Map<ValidateBetId, ValidateBet> validateBetArr = new HashMap<>();

    @Override
    public ValidateBet save(ValidateBet bet) {
        validateBetArr.put(bet.getId(), bet);
        return bet;
    }

    @Override
    public List<ValidateBet> getByGamblerId(GamblerId gamblerId) {
        return Collections.emptyList();
    }

    @Override
    public List<ValidateBet> getValidateBetsByBetId(BetId id) {
        return Collections.emptyList();
    }


}
