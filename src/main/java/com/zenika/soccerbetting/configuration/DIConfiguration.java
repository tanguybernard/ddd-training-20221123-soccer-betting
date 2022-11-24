package com.zenika.soccerbetting.configuration;


import com.zenika.soccerbetting.betting.application.ChooseBet;
import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.gambler.Gambler;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.validate_bet.ChooseBetService;
import com.zenika.soccerbetting.betting.ports.InMemoryBetRepository;
import com.zenika.soccerbetting.betting.ports.InMemoryGamblerRepository;
import com.zenika.soccerbetting.betting.ports.InMemoryValidateBetRepository;
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
    public ChooseBet chooseBet() {
        InMemoryBetRepository bREpo = new InMemoryBetRepository();
        InMemoryGamblerRepository gREpo = new InMemoryGamblerRepository();
        InMemoryValidateBetRepository validateBetRepository = new InMemoryValidateBetRepository();

        bREpo.save(new Bet(new BetId("bet"), "Score"));
        gREpo.save(new Gambler(new GamblerId("gambler")));

        return new ChooseBet(bREpo, gREpo, validateBetRepository, new ChooseBetService(validateBetRepository));
    }
}