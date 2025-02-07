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
public class Monster {

    @MongoId
    private UUID id;
    private string type;
    private int hp;
    private int atk;
    private int def;
    private int vit;

    public Monster(String type, int hp, int atk, int def, int vit) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.vit = vit;
    }

}

