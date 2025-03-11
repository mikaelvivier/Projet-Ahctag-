package com.imt.demo.service;

import com.imt.demo.dao.PlayerDao;
import com.imt.demo.model.Monster;
import com.imt.demo.model.Player;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerDao playerDao;

    public PlayerService(PlayerDao playerdao) {
        this.playerDao = playerdao;
    }

    public void savePlayer(Player player) {
        playerDao.save(player);
    }

    public Player getPlayerById(UUID id) {
        System.out.println("Recherche du joueur avec l'ID : " + id);
        return playerDao.findPlayerById(id);
    }
    public void setMonstersOfPlayer(Player player, Monster monster) {
        if (player == null) {
            throw new IllegalArgumentException("Joueur non trouvé");
        }
        if (player.getMonsters().size() < 3) {
            player.addMonster(monster);
            playerDao.save(player);
        }

    }
}
