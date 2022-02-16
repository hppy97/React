package com.example.gameservice.controller;

import com.example.gameservice.entity.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.gameservice.service.GameService;

@RestController
@RequestMapping("/games")
@Slf4j
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/")
    public Game saveGame(@RequestBody Game game){
        return gameService.saveGame(game);
    }

    @GetMapping("/{id}")
    public Game findGameById(@PathVariable("id") Long gameId){
        log.info("Within Game controller- get game by id");
        return gameService.findGameById(gameId);
    }

}
