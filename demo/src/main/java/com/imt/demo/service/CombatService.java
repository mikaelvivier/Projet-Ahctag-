package com.imt.demo.service;

import com.imt.demo.dao.CombatLogDao;
import com.imt.demo.model.CombatLog;
import com.imt.demo.model.Monster;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CombatService {

    private final CombatLogDao combatLogDao;

    public CombatService(CombatLogDao combatLogDao) {
        this.combatLogDao = combatLogDao;
    }

    public CombatLog fight(Monster monster1, Monster monster2) {
        List<String> fightDetails = new ArrayList<>();

        while (monster1.getHp() > 0 && monster2.getHp() > 0) {
            int damageMonster1 = Math.max(0, monster1.getAtk() - monster2.getDef());
            monster2.setHp(monster2.getHp() - damageMonster1);
            fightDetails.add("Monster 1 attaque Monster 2 avec " + damageMonster1 + " de dégâts.");

            if (monster2.getHp() <= 0) {
                fightDetails.add("Monster 2 est KO !");
                break;
            }

            int damageMonster2 = Math.max(0, monster2.getAtk() - monster1.getDef());
            monster1.setHp(monster1.getHp() - damageMonster2);
            fightDetails.add("Monster 2 attaque Monster 1 avec " + damageMonster2 + " de dégâts.");

            if (monster2.getHp() <= 0) {
                fightDetails.add("Monster 1 est KO !");
                break;
            }
        }

        Monster winner = monster1.getHp() > 0 ? monster1 : monster2;
        CombatLog log = new CombatLog(monster1.getId(), monster2.getId(), winner.getId(), fightDetails);
        combatLogDao.save(log);

        return log;
    }

}
