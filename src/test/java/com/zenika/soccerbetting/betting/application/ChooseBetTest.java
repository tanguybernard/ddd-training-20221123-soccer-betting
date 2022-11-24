package com.zenika.soccerbetting.betting.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.port.stub.InMemoryBetRepository;
import com.zenika.soccerbetting.betting.domain.port.stub.InMemoryGamblerRepository;
import com.zenika.soccerbetting.betting.domain.port.stub.InMemoryValidateBetRepository;
import com.zenika.soccerbetting.betting.domain.validate_bet.BetTYpeAlreadyExist;
import com.zenika.soccerbetting.betting.domain.validate_bet.ChooseBetService;
import com.zenika.soccerbetting.betting.domain.validate_bet.ValidateBet;
import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.gambler.Gambler;
import org.junit.jupiter.api.Test;

import java.util.UUID;


public class ChooseBetTest {


    @Test
    public void chooseBet() throws BetTYpeAlreadyExist {

        //Before
        String gbId = UUID.randomUUID().toString();
        GamblerId gamblerId = new GamblerId(gbId);
        String bId = UUID.randomUUID().toString();
        Bet bet = new Bet(new BetId(bId), "Score");
        Gambler gambler = new Gambler(gamblerId);

        InMemoryBetRepository bREpo = new InMemoryBetRepository();
        bREpo.save(bet);
        InMemoryGamblerRepository gREpo = new InMemoryGamblerRepository();
        gREpo.save(gambler);

        InMemoryValidateBetRepository validateBetRepository = new InMemoryValidateBetRepository();

        ChooseBet useCase = new ChooseBet(bREpo, gREpo, validateBetRepository, new ChooseBetService(validateBetRepository));
        //When
        ValidateBet validate = useCase.chooseBet(bId, gbId);

        //Then
        assertThat(validate.getGamblerId().toEquals(gambler.getId())).isTrue();
        assertThat(validate.betId.equals(bet.getId())).isTrue();
        assertThat(validate.status.value).isEqualTo("Choose");
    }

}
