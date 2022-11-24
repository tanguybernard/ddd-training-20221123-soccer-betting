package com.zenika.soccerbetting.betting.domain.gambler;

public class GamblerId {

    public String value;

    public GamblerId(String value) {
        this.value = value;
    }

    public Boolean toEquals(GamblerId id){

        return this.value == id.value;

    }

}
