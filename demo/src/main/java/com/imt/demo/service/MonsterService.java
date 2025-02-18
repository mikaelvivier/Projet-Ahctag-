package com.imt.demo.service;

import com.imt.demo.dao.MonsterDao;
import com.imt.demo.model.Monster;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterService {

    private final MonsterDao monsterDao;

    public MonsterService(MonsterDao monsterdao) {
        this.monsterDao = monsterdao;
    }

    public void saveMonster(Monster monster) {
        monsterDao.save(monster);
    }

    public List<Monster> findMonstersByType(String type) {
        return monsterDao.findAllByType(type);
    }

}
