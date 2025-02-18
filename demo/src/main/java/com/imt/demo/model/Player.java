package com.imt.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Setter
@Getter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @MongoId
    private UUID id;
    private String name;
    private int lvl;
    private int requireXp;
    private int actualXp;

    public Player(String name, int lvl) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.lvl = lvl;
        this.actualXp = 0;
        this.requireXp = (int) Math.round(50 * Math.pow(1.1, lvl - 1));
    }
    
}
