package com.zenika.soccerbetting.betting.domain.validate_bet;

public class MoneyBet {

    private Integer money;
    private String currency;

    private MoneyBet(Integer money, String currency){

        this.money = money;
        this.currency = currency;
    }

    public boolean toEquals(MoneyBet obj) {
        return this.money.equals(obj.money) && this.currency.equals(obj.currency);
    }

    public static MoneyBet create(Integer money, String currency) throws MoneyBetMustBeSupToZero {

        if(money<=0){
            throw new MoneyBetMustBeSupToZero();
        }
        return new MoneyBet(money, currency);

    }
}
