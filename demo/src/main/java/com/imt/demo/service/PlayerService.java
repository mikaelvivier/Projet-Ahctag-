package com.imt.demo.service;

import com.imt.demo.dao.PlayerDao;
import com.imt.demo.model.Player;
import com.imt.demo.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerDao playerDao;
    private PlayerRepository playerRepository;

    public PlayerService(PlayerDao playerdao) {
        this.playerDao = playerdao;
    }

    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    public Player getPlayerById(UUID id) {
        System.out.println("Recherche du joueur avec l'ID : " + id);
        return playerDao.findById(id).orElse(null);
    }







}
