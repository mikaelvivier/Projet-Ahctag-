package com.imt.demo.model;

import com.imt.demo.dto.Skill;
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
    private Skill skill1;
    private Skill skill2;
    private Skill skill3;

    public Monster(Type type, int hp, int atk, int def, int vit) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.vit = vit;
        initializeSkills();
    }

    private void initializeSkills() {
        switch (type) {
            case FEU:
                this.skill1 = Skill.FIREBALL_LV1;
                this.skill2 = Skill.FLAME_BURST_LV1;
                this.skill3 = Skill.INFERNO_LV1;
                break;
            case EAU:
                this.skill1 = Skill.WATER_BLAST_LV1;
                this.skill2 = Skill.TIDAL_WAVE_LV1;
                this.skill3 = Skill.AQUA_JET_LV1;
                break;
            case VENT:
                this.skill1 = Skill.WIND_SLASH_LV1;
                this.skill2 = Skill.TORNADO_LV1;
                this.skill3 = Skill.AIR_STRIKE_LV1;
                break;
            default:
                throw new IllegalArgumentException("Type de monstre non supporté : " + type);
        }
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

    public Skill getSkill1() {
        return skill1;
    }

    public void setSkill1(Skill skill1) {
        this.skill1 = skill1;
    }

    public Skill getSkill2() {
        return skill2;
    }

    public void setSkill2(Skill skill2) {
        this.skill2 = skill2;
    }

    public Skill getSkill3() {
        return skill3;
    }

    public void setSkill3(Skill skill3) {
        this.skill3 = skill3;
    }
}

