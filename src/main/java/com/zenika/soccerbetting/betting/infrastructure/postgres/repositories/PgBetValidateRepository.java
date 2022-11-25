package com.zenika.soccerbetting.betting.infrastructure.postgres.repositories;

import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.match.MatchId;
import com.zenika.soccerbetting.betting.domain.ports.BetRepository;
import com.zenika.soccerbetting.betting.domain.ports.ValidateBetRepository;
import com.zenika.soccerbetting.betting.domain.validate_bet.ValidateBet;
import com.zenika.soccerbetting.betting.infrastructure.postgres.dao.BetDao;
import com.zenika.soccerbetting.betting.infrastructure.postgres.dao.BetValidateDao;
import com.zenika.soccerbetting.betting.infrastructure.postgres.models.BetEntity;
import com.zenika.soccerbetting.betting.infrastructure.postgres.models.BetValidateEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PgBetValidateRepository implements ValidateBetRepository {

@Autowired
    private BetValidateDao betDao;

    public PgBetValidateRepository(){
    }


    @Override
    public ValidateBet save(ValidateBet validate) {
        BetValidateEntity e = new BetValidateEntity();
        e.setId(validate.getId().value);
        this.betDao.save(e);
        return validate;
    }

    @Override
    public List<ValidateBet> getByGamblerId(GamblerId gamblerId) {
        return Collections.emptyList();
    }
}
