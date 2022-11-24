package com.zenika.soccerbetting.betting.application;

import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.gambler.Gambler;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.ports.BetRepository;
import com.zenika.soccerbetting.betting.domain.ports.GamblerRepository;
import com.zenika.soccerbetting.betting.domain.ports.ValidateBetRepository;
import com.zenika.soccerbetting.betting.domain.validate_bet.*;

import java.util.UUID;

public class ChooseBet {


    private BetRepository betRepository;
    private GamblerRepository gamblerRepository;
    private ValidateBetRepository validateBetRepository;
    private ChooseBetService chooseBetService;

    ChooseBet(
            BetRepository betRepository,
            GamblerRepository gamblerRepository,
            ValidateBetRepository validateBetRepository,
            ChooseBetService chooseBetService
    ){

        this.betRepository = betRepository;
        this.gamblerRepository = gamblerRepository;
        this.validateBetRepository = validateBetRepository;
        this.chooseBetService = chooseBetService;
    }
    
    public ValidateBet chooseBet(String betId, String gamblerId) throws BetTYpeAlreadyExist {


        Bet bet = this.betRepository.getBetById(new BetId(betId));
        Gambler gambler = this.gamblerRepository.getGamblerById(new GamblerId(gamblerId));

        ValidateBet validate = this.chooseBetService.choose(bet, gambler);

        this.validateBetRepository.save(validate);

        return validate;
    }
}
