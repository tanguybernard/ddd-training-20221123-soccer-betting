package com.zenika.soccerbetting.betting.application.event_handlers;

import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.match.MatchCancelled;
import com.zenika.soccerbetting.betting.domain.ports.BetRepository;
import com.zenika.soccerbetting.betting.domain.ports.ValidateBetRepository;
import com.zenika.soccerbetting.betting.domain.validate_bet.ValidateBet;
import com.zenika.soccerbetting.shared_kernel.domain_event.EventHandler;
import com.zenika.soccerbetting.shared_kernel.infrastructure.IntegrationEvent;

import java.util.List;

public class MatchCancelledEventHandler implements EventHandler<MatchCancelled> {

    BetRepository betRepository;
    ValidateBetRepository validateBetRepository;

    //EventBus eventBus // ex: RabbitMq

    @Override
    public void handle(MatchCancelled evt) {

        List<Bet> bets = this.betRepository.getBetsByMatchId(evt.matchId);

bets.forEach(bet -> {
    List<ValidateBet> validateBets = this.validateBetRepository.getValidateBetsByBetId(bet.getId());
    validateBets.forEach(ValidateBet::cancel);
    //repository delete ou save status cancel
    //eventBus.dispatch(new CancelMatchIntegrationEvent())

});


    }
}
