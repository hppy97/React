package com.example.playerservice.service;

import com.example.playerservice.VO.Game;
import com.example.playerservice.VO.ResponseTemplateVo;
import com.example.playerservice.entity.Player;
import com.example.playerservice.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepo;

    @Autowired
    private RestTemplate restTemplate;

    public Player savePlayer(Player player) {
        log.info("Within savePlayer ");
        return playerRepo.save(player);
    }

    public ResponseTemplateVo getPlayerWithGame(Long playerId) {
        ResponseTemplateVo vo=new ResponseTemplateVo();
        Player player= playerRepo.findByPlayerId(playerId);

//        Game game = restTemplate.getForObject("http://localhost:9001/games/"+player.getGameId(), Game.class);
        Game game = restTemplate.getForObject("http://GAME-SERVICE/games/"+player.getGameId(), Game.class);

        vo.setPlayer(player);
        vo.setGame(game);
        return vo;

    }
}
