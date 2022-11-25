package com.zenika.soccerbetting.betting.infrastructure.postgres.dao;


import com.zenika.soccerbetting.betting.infrastructure.postgres.models.BetEntity;
import com.zenika.soccerbetting.betting.infrastructure.postgres.models.GamblerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamblerDao extends JpaRepository<GamblerEntity, String> {
}
