package com.imt.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    // Getters
    // Setters
    @Setter
    @MongoId
    @Getter
    private UUID id;
    @Setter
    private String name;
    @Setter
    private int lvl;
    @Setter
    private int requireXp;
    private int actualXp;
    private int maxList;
    @Setter
    @DBRef
    private List<Monster> monsters=new ArrayList<>();

    public Player(String name, int lvl) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.lvl = lvl;
        this.actualXp = 0;
        this.requireXp = (int) Math.round(50 * Math.pow(1.1, lvl - 1));
        this.maxList = lvl + 9;
    }

    public void setActualXp(int actualXp) {
        if ((this.actualXp + actualXp) > this.requireXp){
            this.upLevel();
            this.actualXp = this.actualXp + actualXp - this.requireXp;
        }
        else {
            this.actualXp += actualXp;
        }
    }

    public void upLevel(){
        this.lvl += 1;
        this.requireXp = (int) Math.ceil(this.requireXp * 1.1);
        this.maxList += 1;
    }

    public void addMonster(Monster monster){
        this.monsters.add(monster);
    }

    public void removeMonster(Monster monster){
        this.monsters.remove(monster);
    }



    
}
