package com.example.gameservice.repository;

import com.example.gameservice.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
    Game findByGameId(Long gameId);
}
