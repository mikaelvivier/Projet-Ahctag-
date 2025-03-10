package com.imt.demo.controller;

import com.imt.demo.dao.PlayerDao;
import com.imt.demo.dto.PlayerJsonDto;
import com.imt.demo.model.Monster;
import com.imt.demo.service.PlayerService;
import com.imt.demo.model.Player;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/player")
public class PlayerController {
    
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("saved !");
    }

    @PostMapping("/save")
    public ResponseEntity<String> createPlayer(@Valid @RequestBody PlayerJsonDto player) {
        playerService.savePlayer(
            new Player(
                player.getName(),
                player.getLvl())
        );
        
        return ResponseEntity.ok("saved !");
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Player> show(@PathVariable UUID id) {
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
    }

    @GetMapping("/show/monster_list/{id}")
    public List<String> showMonsterList(@PathVariable UUID id) {
        Player player = playerService.getPlayerById(id);
        if (player == null) {
            return Collections.emptyList();
        }
        return player.getMonsters();
    }

    @GetMapping("/show/level/{id}")
    public int showLevel(@PathVariable UUID id) {
        Player player = playerService.getPlayerById(id);
        if (player == null) {
            return -1;
        }
        return player.getLvl();
    }

    @PostMapping("/add_exp/{id}/{exp}")
    public void addExp(@PathVariable UUID id, int exp) {
        Player player = playerService.getPlayerById(id);
        if (player == null) {
            return;
        }
        player.setActualXp(player.getActualXp() + exp);
    }



    
}
