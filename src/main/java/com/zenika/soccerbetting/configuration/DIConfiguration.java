package com.zenika.soccerbetting.configuration;


import com.zenika.soccerbetting.betting.application.ChooseBet;
import com.zenika.soccerbetting.betting.domain.ports.BetRepository;
import com.zenika.soccerbetting.betting.domain.ports.GamblerRepository;
import com.zenika.soccerbetting.betting.domain.ports.MatchRepository;
import com.zenika.soccerbetting.betting.domain.ports.ValidateBetRepository;
import com.zenika.soccerbetting.betting.domain.validate_bet.ChooseBetService;
import com.zenika.soccerbetting.betting.infrastructure.postgres.dao.BetDao;
import com.zenika.soccerbetting.betting.infrastructure.postgres.repositories.PgBetRepository;
import com.zenika.soccerbetting.betting.infrastructure.postgres.repositories.PgBetValidateRepository;
import com.zenika.soccerbetting.betting.infrastructure.postgres.repositories.PgGamblerRepository;
import com.zenika.soccerbetting.betting.ports.stubs.InMemoryBetRepository;
import com.zenika.soccerbetting.betting.ports.stubs.InMemoryGamblerRepository;
import com.zenika.soccerbetting.betting.ports.stubs.InMemoryMatchRepository;
import com.zenika.soccerbetting.betting.ports.stubs.InMemoryValidateBetRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DIConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public BetRepository betRepository(){
        return new PgBetRepository();
    }

    @Bean
    public GamblerRepository gamblerRepository(){
        return new PgGamblerRepository();
    }

    @Bean
    public ValidateBetRepository validateBetRepository(){
        return new PgBetValidateRepository();
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