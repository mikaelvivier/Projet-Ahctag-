package com.imt.demo.repository;

import com.imt.demo.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayerRepository extends MongoRepository<Player, String> {

    Optional<Player> findById(UUID id);

}
