package com.imt.demo.service;

import com.imt.demo.dao.MonsterDao;
import com.imt.demo.model.Monster;
import com.imt.demo.model.Monster;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class MonsterService {

    Random randomNumbers = new Random();

    private final MonsterDao monsterDao;

    public MonsterService(MonsterDao monsterdao) {
        this.monsterDao = monsterdao;
    }

    public void saveMonster(Monster monster) {
        monsterDao.save(monster);
    }

    public Monster getMonsterById(UUID id) {
        System.out.println("Recherche du monster avec l'ID : " + id);
        return monsterDao.findMonsterById(id);
    }

    /*
    public Monster setStatsOfMonster(Monster monster) {
        monster.setAtk(monster.getAtk() + 1);
        monster.setDef(monster.getDef() + 1);
        monster.setHp(monster.getHp() + 10);
        monster.setVit(monster.getVit() + 10);
        int randomSkill = (randomNumbers.nextInt(3));
        switch(randomSkill){
            case 0:
                monster.setSkill1(monster.getSkill1());
        }



    }
    */


    public void deleteMonster(UUID monsterId) {
        Monster monster = getMonsterById(monsterId);
        if (monster == null) {
            throw new IllegalArgumentException("Le monster n'existe pas");
        }
        monsterDao.delete(monster);
    }

    public List<Monster> findMonstersByType(String type) {
        return monsterDao.findAllByType(type);
    }


}
