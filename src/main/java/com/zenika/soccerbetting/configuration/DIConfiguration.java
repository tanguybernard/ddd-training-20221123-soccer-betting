package com.zenika.soccerbetting.configuration;


import com.zenika.soccerbetting.betting.application.ChooseBet;
import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.gambler.Gambler;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.match.MatchId;
import com.zenika.soccerbetting.betting.domain.ports.BetRepository;
import com.zenika.soccerbetting.betting.domain.ports.GamblerRepository;
import com.zenika.soccerbetting.betting.domain.ports.MatchRepository;
import com.zenika.soccerbetting.betting.domain.ports.ValidateBetRepository;
import com.zenika.soccerbetting.betting.domain.validate_bet.ChooseBetService;
import com.zenika.soccerbetting.betting.ports.stubs.InMemoryBetRepository;
import com.zenika.soccerbetting.betting.ports.stubs.InMemoryGamblerRepository;
import com.zenika.soccerbetting.betting.ports.stubs.InMemoryMatchRepository;
import com.zenika.soccerbetting.betting.ports.stubs.InMemoryValidateBetRepository;
import io.micrometer.core.instrument.config.validate.Validated;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Configuration
public class DIConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public BetRepository betRepository(){
        return new InMemoryBetRepository();
    }

    @Bean
    public GamblerRepository gamblerRepository(){
        return new InMemoryGamblerRepository();
    }

    @Bean
    public ValidateBetRepository validateBetRepository(){
        return new InMemoryValidateBetRepository();
    }

    @Bean
    public MatchRepository matchRepository(){
        return new InMemoryMatchRepository();
    }

    @Bean
    public ChooseBet chooseBet() {
        ValidateBetRepository validateBetRepository = validateBetRepository();
        return new ChooseBet(betRepository(), gamblerRepository(), validateBetRepository, new ChooseBetService(validateBetRepository));
    }
}