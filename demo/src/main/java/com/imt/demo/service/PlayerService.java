package com.imt.demo.service;

import com.imt.demo.dao.PlayerDao;
import com.imt.demo.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return playerDao.findById(id).orElse(null);
    }

    public List<Player> getAllPlayers() {
        return playerDao.findAll();
    }







}
