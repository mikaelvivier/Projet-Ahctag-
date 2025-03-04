package com.imt.demo.controller;

import com.imt.demo.dto.MonsterJsonDto;
import com.imt.demo.dto.Type;
import com.imt.demo.service.MonsterService;
import com.imt.demo.model.Monster;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monster")
public class MonsterController {

    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> createMonster(@Valid @RequestBody MonsterJsonDto monster) {
        monsterService.saveMonster(
                new Monster(
                        monster.getType(),
                        monster.getHp(),
                        monster.getAtk(),
                        monster.getDef(),
                        monster.getVit())
        );

        return ResponseEntity.ok("saved !");
    }

    @GetMapping("/{monster}")
    public ResponseEntity<List<MonsterJsonDto>> getMonsters(@PathVariable String type) {
        List<MonsterJsonDto> monstersByType = monsterService.findMonstersByType(type)
                .stream()
                .map(monster -> new MonsterJsonDto(
                        Type.valueOf(String.valueOf(monster.getType())),
                        monster.getHp(),
                        monster.getAtk(),
                        monster.getDef(),
                        monster.getVit()))
                .toList();

        return ResponseEntity.ok(monstersByType);
    }

}
