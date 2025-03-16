package com.imt.demo.controller;

import com.imt.demo.dto.MonsterJsonDto;
import com.imt.demo.dto.Type;
import com.imt.demo.service.MonsterService;
import com.imt.demo.model.Monster;
import com.imt.demo.service.TokenValidationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.validation.Valid;
import org.apache.catalina.realm.AuthenticatedUserRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import javax.naming.AuthenticationException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/monster")
public class MonsterController {

    private final MonsterService monsterService;

    @Autowired
    private TokenValidationService tokenValidationService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> createMonster(@RequestHeader("Authorization") String authHeader, @Valid @RequestBody MonsterJsonDto monster) {
        try {
            tokenValidationService.authenticate(authHeader);
            monsterService.saveMonster(
                    new Monster(
                            monster.getType(),
                            monster.getHp(),
                            monster.getAtk(),
                            monster.getDef(),
                            monster.getVit())
            );

            return ResponseEntity.ok("save");


        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/show/monsters")
    public ResponseEntity<List<Monster>> getMonsters(@RequestHeader("Authorization") String authHeader) {
        try {
            tokenValidationService.authenticate(authHeader);

            return ResponseEntity.ok(monsterService.getMonsters());
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/levelup/{monsterId}")
    public ResponseEntity<Monster> levelUpMonster(@RequestHeader("Authorization") String authHeader, @PathVariable UUID monsterId) {
        try {
            tokenValidationService.authenticate(authHeader);
            Monster monster = monsterService.getMonsterById(monsterId);
            monsterService.setStatsOfMonster(monster);
            return ResponseEntity.ok(monster);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteMonster(@RequestHeader("Authorization") String authHeader, @PathVariable UUID id) {
        try {
            tokenValidationService.authenticate(authHeader);
            monsterService.deleteMonster(id);

            return ResponseEntity.ok("deleted !");
        }
        catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }



    @GetMapping("/type/{type}")
    public ResponseEntity<List<MonsterJsonDto>> getMonsters(@RequestHeader("Authorization") String authHeader, @PathVariable String type) {
        try {
            tokenValidationService.authenticate(authHeader);
            List<MonsterJsonDto> monstersByType = monsterService.findMonstersByType(type)
                    .stream()
                    .map(monster -> new MonsterJsonDto(
                            monster.getId(),
                            Type.valueOf(String.valueOf(monster.getType())),
                            monster.getHp(),
                            monster.getAtk(),
                            monster.getDef(),
                            monster.getVit()))
                    .toList();

            return ResponseEntity.ok(monstersByType);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.emptyList());
        }
    }
}

