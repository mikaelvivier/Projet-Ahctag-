package com.imt.demo.service;

import com.imt.demo.dao.MonsterDao;
import com.imt.demo.dto.Skill;
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

    public Monster setStatsOfMonster(Monster monster) {
        // Augmenter les stats de base du monstre
        monster.setAtk(monster.getAtk() + 1);
        monster.setDef(monster.getDef() + 1);
        monster.setHp(monster.getHp() + 10);
        monster.setVit(monster.getVit() + 10);

        // Sélectionner une compétence aléatoire
        int randomSkillIndex = randomNumbers.nextInt(3);

        if (randomSkillIndex == 0) {
            monster.setSkill1(upgradeSkill(monster.getSkill1(), monster.getSkill2(), monster.getSkill3()));
        } else if (randomSkillIndex == 1) {
            monster.setSkill2(upgradeSkill(monster.getSkill2(), monster.getSkill3(), monster.getSkill1()));
        } else {
            monster.setSkill3(upgradeSkill(monster.getSkill3(), monster.getSkill1(), monster.getSkill2()));
        }
        monsterDao.save(monster);
        return monster;

    }

    public List<Monster> getMonsters() {
        return monsterDao.findAll();
    }

    private Skill upgradeSkill(Skill skill, Skill fallback1, Skill fallback2) {
        String skillName = skill.name();

        if (skillName.endsWith("_LV1")) {
            return Skill.valueOf(skillName.replace("_LV1", "_LV2"));
        } else if (skillName.endsWith("_LV2")) {
            return Skill.valueOf(skillName.replace("_LV2", "_LV3"));
        } else {
            // Si la compétence est déjà LV3, on essaie d'améliorer une autre
            return upgradeSkill(fallback1, fallback2, skill);
        }
    }



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
