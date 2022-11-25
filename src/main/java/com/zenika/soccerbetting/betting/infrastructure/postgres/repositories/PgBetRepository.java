package com.zenika.soccerbetting.betting.infrastructure.postgres.repositories;

import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.match.MatchId;
import com.zenika.soccerbetting.betting.domain.ports.BetRepository;
import com.zenika.soccerbetting.betting.infrastructure.postgres.dao.BetDao;
import com.zenika.soccerbetting.betting.infrastructure.postgres.models.BetEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PgBetRepository implements BetRepository {


    @Autowired
    private BetDao betDao;

    public PgBetRepository(){
    }


    @Override
    public void save(Bet bet) {

        BetEntity e = new BetEntity();
        e.setId(bet.getId().id);
        this.betDao.save(e);

    }

    @Override
    public Bet getBetById(BetId betId) {
        Optional<BetEntity> e = this.betDao.findById(betId.id);
        if(e.isPresent()){
            return new Bet(new BetId(e.get().id), new MatchId(""), "Score");
        }
        return null;
    }

    @Override
    public List<Bet> getBetsByMatchId(MatchId matchId) {
        return null;
    }
}
