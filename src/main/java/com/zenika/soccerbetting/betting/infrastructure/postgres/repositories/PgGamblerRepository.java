package com.zenika.soccerbetting.betting.infrastructure.postgres.repositories;

import com.zenika.soccerbetting.betting.domain.gambler.Gambler;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.ports.GamblerRepository;
import com.zenika.soccerbetting.betting.domain.ports.ValidateBetRepository;
import com.zenika.soccerbetting.betting.domain.validate_bet.ValidateBet;
import com.zenika.soccerbetting.betting.infrastructure.postgres.dao.BetValidateDao;
import com.zenika.soccerbetting.betting.infrastructure.postgres.dao.GamblerDao;
import com.zenika.soccerbetting.betting.infrastructure.postgres.models.BetValidateEntity;
import com.zenika.soccerbetting.betting.infrastructure.postgres.models.GamblerEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PgGamblerRepository implements GamblerRepository {

    @Autowired
    private GamblerDao dao;

    public PgGamblerRepository(){
    }


    @Override
    public void save(Gambler g) {
        GamblerEntity e = new GamblerEntity();
        e.setId(g.getId().value);
        this.dao.save(e);
    }

    @Override
    public Gambler getGamblerById(GamblerId gamblerId) {
        Optional<GamblerEntity> e = this.dao.findById(gamblerId.value);
        return e.map(gamblerEntity -> new Gambler(new GamblerId(gamblerEntity.id))).orElse(null);
    }
}
