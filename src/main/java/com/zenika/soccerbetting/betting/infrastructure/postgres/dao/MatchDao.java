package com.zenika.soccerbetting.betting.infrastructure.postgres.dao;


import com.zenika.soccerbetting.betting.infrastructure.postgres.models.BetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchDao extends JpaRepository<BetEntity, String> {
}
