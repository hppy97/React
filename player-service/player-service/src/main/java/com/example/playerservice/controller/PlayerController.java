package com.example.playerservice.controller;

import com.example.playerservice.VO.ResponseTemplateVo;
import com.example.playerservice.entity.Player;
import com.example.playerservice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/")
    public Player savePlayer(@RequestBody Player player){
        return playerService.savePlayer(player);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getPlayerWithGame(@PathVariable("id") Long playerId){
        return playerService.getPlayerWithGame(playerId);
    }


}
