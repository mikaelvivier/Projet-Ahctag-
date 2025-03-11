package com.imt.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.imt.demo.model.Monster;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DTO (Data Transfer Object) est un objet utilisé
// pour transférer des données entre les couches d'une application.

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerJsonDto {

    @NotNull private String name;
    @Min(1) private int lvl;
    @Min(1) private int requireXp;
    @Min(1) private int actualXp;
    @Min(1) private int maxList;
    private List<Monster> monsters=new ArrayList<>();

    // Getters
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

    public int getMaxList() {
        return maxList;
    }


    // Setters
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

    public void setMaxList(int maxList) {
        this.maxList = maxList;
    }

    public void addMonster(Monster monster){
        this.monsters.add(monster);
    }

    public void removeMonster(Monster monster){
        this.monsters.remove(monster);
    }

}
