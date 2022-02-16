package com.example.gameservice.service;

import com.example.gameservice.entity.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gameservice.repository.GameRepository;

@Service
@Slf4j
public class GameService {

    @Autowired
    private GameRepository gameRepo;


    public Game saveGame(Game game) {
      log.info("Inside game com.example.gameService.service- save game");
        return gameRepo.save(game);
    }

    public Game findGameById(Long gameId){
        log.info("Inside game com.example.gameService.service- save game");
        return gameRepo.findByGameId(gameId);
    }
}
