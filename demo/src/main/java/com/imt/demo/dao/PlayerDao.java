package com.imt.demo.dao;

import com.imt.demo.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//DAO (Data Access Object) est un objet ou une interface qui
// fournit des méthodes pour interagir avec la base de données.

@Repository
public interface PlayerDao extends MongoRepository<Player, UUID> {

    List<Player> findAll();

}
