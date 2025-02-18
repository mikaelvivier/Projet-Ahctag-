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
    private String type;
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

     // Getters
     public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getVit() {
        return vit;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

}

