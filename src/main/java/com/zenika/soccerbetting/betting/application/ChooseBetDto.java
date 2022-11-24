package com.zenika.soccerbetting.betting.application;

import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.gambler.Gambler;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.ports.BetRepository;
import com.zenika.soccerbetting.betting.domain.ports.GamblerRepository;
import com.zenika.soccerbetting.betting.domain.ports.ValidateBetRepository;
import com.zenika.soccerbetting.betting.domain.validate_bet.*;

public class ChooseBetDto {


    public String betId;
    public String gamblerId;
    public Integer money;
    public String currency;

    public ChooseBetDto(String betId, String gamblerId, Integer money, String currency)  {
        this.betId = betId;
        this.gamblerId = gamblerId;
        this.money = money;
        this.currency = currency;
    }
}
