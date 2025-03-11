package com.imt.demo.service;

import com.imt.demo.dao.MonsterDao;
import com.imt.demo.model.Monster;
import com.imt.demo.model.Monster;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.List;
import java.util.UUID;

@Service
public class MonsterService {

    private final MonsterDao monsterDao;

    Random randomNumbers = new Random();

    public MonsterService(MonsterDao monsterdao) {
        this.monsterDao = monsterdao;
    }

    public void saveMonster(Monster monster) {
        monsterDao.save(monster);
    }

    public Monster invocateMonster() {
        List<Monster> allMonsters = monsterDao.findAll();

        if (allMonsters.isEmpty()) {
            throw new IllegalStateException("No monsters available for invocation");
        }

        // Génération d'un monstre aléatoire selon son taux de probabilité
        return getRandomMonster(allMonsters);
    }

    public Monster getRandomMonster(List<Monster> allMonsters) {
        if (allMonsters == null) {
            throw new IllegalArgumentException("Il n'y a aucun monstres");
        }
        int randomNumMonster = (randomNumbers.nextInt(allMonsters.size()));
        Monster baseMonster = allMonsters.get(randomNumMonster);
        return new Monster(
                baseMonster.getId(), // ID unique pour le nouveau monstre invoqué
                baseMonster.getType(),
                baseMonster.getHp(),
                baseMonster.getAtk(),
                baseMonster.getDef(),
                baseMonster.getVit(),
                baseMonster.getSkill1(),
                baseMonster.getSkill2(),
                baseMonster.getSkill3()
        );
        }

    public List<Monster> findMonstersByType(String type) {
        return monsterDao.findAllByType(type);
    }


}
