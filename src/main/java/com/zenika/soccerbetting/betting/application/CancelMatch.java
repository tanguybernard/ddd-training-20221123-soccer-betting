package com.zenika.soccerbetting.betting.application;


import com.zenika.soccerbetting.betting.domain.match.Match;
import com.zenika.soccerbetting.betting.domain.match.MatchCancelled;
import com.zenika.soccerbetting.betting.domain.match.MatchId;
import com.zenika.soccerbetting.betting.domain.ports.BetRepository;
import com.zenika.soccerbetting.betting.domain.ports.GamblerRepository;
import com.zenika.soccerbetting.betting.domain.ports.MatchRepository;
import com.zenika.soccerbetting.betting.domain.ports.ValidateBetRepository;
import com.zenika.soccerbetting.betting.domain.validate_bet.*;
import com.zenika.soccerbetting.shared_kernel.domain_event.DomainEventPublisher;

public class CancelMatch {

    private BetRepository betRepository;
    private GamblerRepository gamblerRepository;
    private ValidateBetRepository validateBetRepository;
    private ChooseBetService chooseBetService;
    private MatchRepository matchRepository;

    public CancelMatch(
            BetRepository betRepository,
            GamblerRepository gamblerRepository,
            ValidateBetRepository validateBetRepository,
            ChooseBetService chooseBetService,
            MatchRepository matchRepository
    ){

        this.betRepository = betRepository;
        this.gamblerRepository = gamblerRepository;
        this.validateBetRepository = validateBetRepository;
        this.chooseBetService = chooseBetService;
        this.matchRepository = matchRepository;
    }
    
    public void cancelMatch(String matchId) {

        Match match = this.matchRepository.getMatchById(new MatchId(matchId));
        match.cancel();

        /*
        Alternative, dispatch au fur et a mesure
        DomainEventPublisher::dispatch(new MatchCancelled(matchId))

        traitement2

        traitement3
        */


        match.pullDomainEvents().forEach(DomainEventPublisher::dispatch);

        this.matchRepository.delete(match);

    }
}
