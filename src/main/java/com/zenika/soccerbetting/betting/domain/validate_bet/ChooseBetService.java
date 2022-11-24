package com.zenika.soccerbetting.betting.domain.validate_bet;

import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.gambler.Gambler;
import com.zenika.soccerbetting.betting.domain.ports.ValidateBetRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ChooseBetService {

    private ValidateBetRepository repository;

    public ChooseBetService(ValidateBetRepository repository){

        this.repository = repository;
    }


    public ValidateBet choose(Bet bet, Gambler gambler) throws BetTYpeAlreadyExist {
        List<ValidateBet> validateBetList = this.repository.getByGamblerId(gambler.getId());

        Optional<ValidateBet> found = validateBetList.stream().filter(v -> v.type.equals(bet.type)).findFirst();

        if(found.isPresent()) {
            throw new BetTYpeAlreadyExist();
        }
        else {
            return repository.save(ValidateBet.create(
                    new ValidateBetId(UUID.randomUUID().toString()),
                    bet.getId(),
                    gambler.getId(),
                    new Status("Choose"))
            );
        }

    }

}
