package com.imt.demo.dao;

import com.imt.demo.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//DAO (Data Access Object) est un objet ou une interface qui
// fournit des méthodes pour interagir avec la base de données.

@Repository
public interface MonsterDao extends MongoRepository<Monster, UUID> {

    List<Monster> findAllByType(String type);

}
