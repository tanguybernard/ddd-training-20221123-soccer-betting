package com.zenika.soccerbetting.betting.presentation;

import com.zenika.soccerbetting.betting.application.ChooseBet;
import com.zenika.soccerbetting.betting.application.ChooseBetDto;
import com.zenika.soccerbetting.betting.domain.validate_bet.BetTYpeAlreadyExist;
import com.zenika.soccerbetting.betting.domain.validate_bet.MoneyBetMustBeSupToZero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bet/choose")
public class BetController {

    private final ChooseBet chooseBet;

    public BetController(ChooseBet chooseBet){
        this.chooseBet = chooseBet;
    }

    @PostMapping
    public ResponseEntity<ChooseBet> chooseBet(@RequestBody ChooseBetDto chooseBetDto) {
        try {

            chooseBet.chooseBet(chooseBetDto);
        } catch (BetTYpeAlreadyExist | MoneyBetMustBeSupToZero e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
