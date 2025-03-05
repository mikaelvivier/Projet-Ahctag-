package com.imt.demo.model;

import com.imt.demo.dto.Type;
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
    private Type type;
    private int hp;
    private int atk;
    private int def;
    private int vit;

    public Monster(Type type, int hp, int atk, int def, int vit) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.vit = vit;
    }

    // Getter et Setter pour id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    // Getter et Setter pour type
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    // Getter et Setter pour hp
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    // Getter et Setter pour atk
    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    // Getter et Setter pour def
    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    // Getter et Setter pour vit
    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

}

