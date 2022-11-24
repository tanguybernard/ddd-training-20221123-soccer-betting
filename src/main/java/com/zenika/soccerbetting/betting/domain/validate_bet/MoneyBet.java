package com.zenika.soccerbetting.betting.domain.validate_bet;

public class MoneyBet {

    private Integer money;
    private String currency;

    MoneyBet(Integer money, String currency){

        this.money = money;
        this.currency = currency;
    }

    public boolean toEquals(MoneyBet obj) {
        return this.money.equals(obj.money) && this.currency.equals(obj.currency);
    }
}
