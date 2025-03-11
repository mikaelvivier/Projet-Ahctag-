package com.imt.demo.controller;

import com.imt.demo.dto.PlayerJsonDto;
import com.imt.demo.model.Monster;
import com.imt.demo.service.PlayerService;
import com.imt.demo.model.Player;
import com.imt.demo.service.TokenValidationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/player")
public class PlayerController {
    
    private final PlayerService playerService;

    @Autowired
    private final TokenValidationService tokenValidationService;

    public PlayerController(PlayerService playerService, TokenValidationService tokenValidationService) {
        this.playerService = playerService;
        this.tokenValidationService = tokenValidationService;
    }



    @PostMapping("/save")
    public ResponseEntity<UUID> createPlayer(@RequestHeader("Authorization") String authHeader,@Valid @RequestBody PlayerJsonDto player) {
        try {
            tokenValidationService.authenticate(authHeader);
            playerService.savePlayer(
                    new Player(
                            player.getName(),
                            player.getLvl())
            );
            return ResponseEntity.ok(player.getId());
        }
        catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        

    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Player> show(@RequestHeader("Authorization") String authHeader, @PathVariable UUID id) {
        try {
            tokenValidationService.authenticate(authHeader);
            try {
                Player player = playerService.getPlayerById(id);
                if (player == null) {
                    return ResponseEntity.notFound().build();
                }
                return ResponseEntity.ok(player);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.internalServerError().body(null);
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    @GetMapping("/show/monster_list/{id}")
    public ResponseEntity<List<Monster>> showMonsterList(@RequestHeader("Authorization") String authHeader, @PathVariable UUID id) {
        try {
            tokenValidationService.authenticate(authHeader);
            Player player = playerService.getPlayerById(id);
            if (player == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
            }
            return ResponseEntity.ok(player.getMonsters());
        }
        catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.emptyList());
    }


    }

    @GetMapping("/show/level/{id}")
    public ResponseEntity<Integer> showLevel(@RequestHeader("Authorization") String authHeader, @PathVariable UUID id) {
        try {
            tokenValidationService.authenticate(authHeader);
            Player player = playerService.getPlayerById(id);
            if (player == null) {
                ResponseEntity.status(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(player.getLvl());
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/add_exp/{id}/{exp}")
    public ResponseEntity.BodyBuilder addExp(@RequestHeader("Authorization") String authHeader, @PathVariable UUID id, int exp) {
        try {
            tokenValidationService.authenticate(authHeader);
            Player player = playerService.getPlayerById(id);
            if (player == null) {
                return null;
            }
            player.setActualXp(exp);
        }
         catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }
        return null;
    }



    
}
