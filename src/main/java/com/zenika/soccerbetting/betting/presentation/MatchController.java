package com.zenika.soccerbetting.betting.presentation;

import com.zenika.soccerbetting.betting.application.CancelMatch;
import com.zenika.soccerbetting.betting.application.ChooseBet;
import com.zenika.soccerbetting.betting.application.ChooseBetDto;
import com.zenika.soccerbetting.betting.domain.validate_bet.BetTYpeAlreadyExist;
import com.zenika.soccerbetting.betting.domain.validate_bet.MoneyBetMustBeSupToZero;
import com.zenika.soccerbetting.betting.domain.validate_bet.ValidateBet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final CancelMatch cancelMatch;

    public MatchController(CancelMatch cancelMatch){
        this.cancelMatch = cancelMatch;
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<BetDto> cancel(@PathVariable String id) {
        try {
            cancelMatch.cancelMatch(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


    private BetDto toDto(ValidateBet bet){
        return new BetDto(bet.getId().value, bet.getGamblerId().value);
    }

}
