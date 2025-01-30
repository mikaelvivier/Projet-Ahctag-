package com.imt.demo.dao;

import com.imt.demo.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//DAO (Data Access Object) est un objet ou une interface qui
// fournit des méthodes pour interagir avec la base de données.

@Repository
public interface UserDao extends MongoRepository<User, ObjectId> {

    Optional<User> findByEmail(String email);
    
}
