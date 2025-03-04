package com.imt.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//DTO (Data Transfer Object) est un objet utilisé
// pour transférer des données entre les couches d'une application.

@Setter
@Getter
@NoArgsConstructor
public class MonsterJsonDto {

    private Type type;
    @Min(1) private int hp;
    @Min(1) private int atk;
    @Min(1) private int def;
    @Min(1) private int vit;

    public MonsterJsonDto(Type type, int hp, int atk, int def, int vit) {
        this.type = type;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.vit = vit;
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
