package com.imt.demo.service;

import com.imt.demo.dao.MonsterDao;
import com.imt.demo.model.Monster;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class MonsterService {

    private final MonsterDao monsterDao;

    public MonsterService(MonsterDao monsterdao) {
        this.monsterDao = monsterdao;
    }

    public void saveMonster(Monster monster) {
        monsterDao.save(monster);
    }

    public Monster invocateMonster(UUID id) {
        Monster monster = monsterDao.findMonsterById(id);

        if (monster == null) {
            throw new IllegalArgumentException("Monster not found");
        }

        return monster;
    }
}
