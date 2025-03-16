package com.imt.demo.controller;

import com.imt.demo.model.CombatLog;
import com.imt.demo.service.CombatService;
import com.imt.demo.service.MonsterService;
import com.imt.demo.model.Monster;
import com.imt.demo.service.TokenValidationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fight")
public class FightController {

    private final MonsterService monsterService;
    private final CombatService combatService;

    @Autowired
    private TokenValidationService tokenValidationService;

    public FightController(MonsterService monsterService, CombatService combatService, TokenValidationService tokenValidationService) {
        this.monsterService = monsterService;
        this.combatService = combatService;
        this.tokenValidationService = tokenValidationService;
    }


    @PostMapping("{monster1Id}/{monster2Id}")
    public ResponseEntity<CombatLog> fight(@RequestHeader("Authorization") String authHeader, @Valid @PathVariable UUID monster1Id, @Valid @PathVariable UUID monster2Id) {
        try {
            tokenValidationService.authenticate(authHeader);
            Monster monster1 = monsterService.getMonsterById(monster1Id);
            Monster monster2 = monsterService.getMonsterById(monster2Id);
            if (monster1 == null || monster2 == null) {
                return ResponseEntity.badRequest().build();
            }
            CombatLog log = combatService.fight(monster1, monster2);
            return ResponseEntity.ok(log);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }


    }
}