package com.imt.demo.controller;

import com.imt.demo.dto.MonsterJsonDto;
import com.imt.demo.dto.Type;
import com.imt.demo.model.Player;
import com.imt.demo.service.MonsterService;
import com.imt.demo.model.Monster;
import com.imt.demo.service.PlayerService;
import com.imt.demo.service.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invocate")
public class InvocationController {

    private final MonsterService monsterService;

    private final PlayerService playerService;

    @Autowired
    private TokenValidationService tokenValidationService;

    public InvocationController(MonsterService monsterService, PlayerService playerService) {
        this.monsterService = monsterService;
        this.playerService = playerService;
    }

    @GetMapping("monster")
    public ResponseEntity<Monster> invocate(){
        Monster monster = monsterService.invocateMonster();
        return ResponseEntity.ok(monster);
    }

    @GetMapping("player/{idPlayer}")
    public ResponseEntity<Player> player(@PathVariable UUID idPlayer){
        Player player = playerService.getPlayerById(idPlayer);
        return ResponseEntity.ok(player);
    }


    @PostMapping("/invocateMonstersForPlayer/{idPlayer}")
    public ResponseEntity<Player> invocateMonstersforPlayer(@RequestHeader("Authorization") String authHeader, @PathVariable UUID idPlayer) {
        try {
            tokenValidationService.authenticate(authHeader);
            Player player= playerService.getPlayerById(idPlayer);
            for (int i=0;i<3;i++){
                playerService.setMonstersOfPlayer(player, monsterService.invocateMonster());
            }

            return ResponseEntity.ok(player);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}

