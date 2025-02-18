package com.imt.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
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
    private List<Monster> monsters=new ArrayList<Monster>();
    private int maxList;

    public Player(String name, int lvl) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.lvl = lvl;
        this.actualXp = 0;
        this.requireXp = (int) Math.round(50 * Math.pow(1.1, lvl - 1));
        this.maxList = lvl + 9;
    }
    
    // Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public int getRequireXp() {
        return requireXp;
    }

    public int getActualXp() {
        return actualXp;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public int getMaxList() {
        return maxList;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setRequireXp(int requireXp) {
        this.requireXp = requireXp;
    }

    public void setActualXp(int actualXp) {
        this.actualXp = actualXp;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public void setMaxList(int maxList) {
        this.maxList = maxList;
    }


    
}
