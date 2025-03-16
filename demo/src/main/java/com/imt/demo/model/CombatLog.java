package com.imt.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document
public class CombatLog {

    @Id
    private UUID id;
    private UUID monster1Id;
    private UUID monster2Id;
    private UUID winnerId;
    private List<String> fightDetails;
    private LocalDateTime timestamp;

    public CombatLog(UUID monster1Id, UUID monster2Id, UUID winnerId, List<String> fightDetails) {
        this.id = UUID.randomUUID();
        this.monster1Id = monster1Id;
        this.monster2Id = monster2Id;
        this.winnerId = winnerId;
        this.fightDetails = fightDetails;
        this.timestamp = LocalDateTime.now();
    }

    public UUID getId() { return id; }
    public UUID getMonster1Id() { return monster1Id; }
    public UUID getMonster2Id() { return monster2Id; }
    public UUID getWinnerId() { return winnerId; }
    public List<String> getFightDetails() { return fightDetails; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
