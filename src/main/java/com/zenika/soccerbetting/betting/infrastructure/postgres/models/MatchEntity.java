package com.zenika.soccerbetting.betting.infrastructure.postgres.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MatchEntity {

    public void setId(String id){
        this.id = id;
    }

    @Id
    public String id;

}
