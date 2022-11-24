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


public record BetDto(String id, String gamblerId) {
}
