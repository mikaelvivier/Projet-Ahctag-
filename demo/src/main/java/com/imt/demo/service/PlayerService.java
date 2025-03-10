package com.imt.demo.service;

import com.imt.demo.dao.PlayerDao;
import com.imt.demo.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerDao playerDao;

    public PlayerService(PlayerDao playerdao) {
        this.playerDao = playerdao;
    }

    public void savePlayer(Player player) {
        playerDao.save(player);
    }





}
