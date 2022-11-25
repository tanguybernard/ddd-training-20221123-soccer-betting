package com.zenika.soccerbetting;

import com.zenika.soccerbetting.betting.application.event_handlers.MatchCancelledEventHandler;
import com.zenika.soccerbetting.betting.domain.match.MatchCancelled;
import com.zenika.soccerbetting.shared_kernel.domain_event.DomainEventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SoccerBettingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(SoccerBettingApplication.class, args);


        DomainEventPublisher.register(new MatchCancelledEventHandler(), MatchCancelled.class.getName());
    }
}
