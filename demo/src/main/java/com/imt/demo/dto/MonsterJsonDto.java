package com.imt.demo.dto;

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
public class MonsterJsonDto {

    @NotNull private String type; 
    @Min(1) private int hp;
    @Min(1) private int atk;
    @Min(1) private int def;
    @Min(1) private int vit;

    // Getters
    public String getType() {
        return type;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getAtk() {
        return atk;
    }

    public Integer getDef() {
        return def;
    }

    public Integer getVit() {
        return vit;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public void setVit(Integer vit) {
        this.vit = vit;
    }
}
