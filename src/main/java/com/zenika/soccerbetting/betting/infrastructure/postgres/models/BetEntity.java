package com.zenika.soccerbetting.betting.infrastructure.postgres.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BetEntity {

    public void setId(String id){
        this.id = id;
    }

    @Id
    public String id;

}
