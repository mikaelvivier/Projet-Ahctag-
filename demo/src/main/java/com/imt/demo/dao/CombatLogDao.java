package com.imt.demo.dao;

import com.imt.demo.model.CombatLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.UUID;

public interface CombatLogDao extends MongoRepository<CombatLog, UUID> {
    Optional<CombatLog> findById(UUID id);
}
