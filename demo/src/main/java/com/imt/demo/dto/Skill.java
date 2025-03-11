package com.imt.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Skill {

    // Compétences de type Feu
    FIREBALL(100, 0.2, 3, 0, 5),
    FIREBALL_LV2(115, 0.25, 2, 0, 5),
    FIREBALL_LV3(132, 0.3, 2, 0, 5),

    FLAME_BURST(120, 0.3, 4, 0, 5),
    FLAME_BURST_LV2(138, 0.35, 3, 0, 5),
    FLAME_BURST_LV3(159, 0.4, 3, 0, 5),

    INFERNO(150, 0.5, 5, 0, 6),
    INFERNO_LV2(173, 0.55, 4, 0, 6),
    INFERNO_LV3(199, 0.6, 4, 0, 6),

    // Compétences de type Eau
    WATER_BLAST(85, 0.3, 2, 0, 4),
    WATER_BLAST_LV2(98, 0.35, 2, 0, 4),
    WATER_BLAST_LV3(113, 0.4, 1, 0, 4),

    TIDAL_WAVE(110, 0.35, 3, 0, 5),
    TIDAL_WAVE_LV2(126, 0.4, 2, 0, 5),
    TIDAL_WAVE_LV3(145, 0.45, 2, 0, 5),

    AQUA_JET(90, 0.25, 2, 0, 4),
    AQUA_JET_LV2(104, 0.3, 2, 0, 4),
    AQUA_JET_LV3(120, 0.35, 1, 0, 4),

    // Compétences de type Vent
    WIND_SLASH(90, 0.25, 4, 0, 5),
    WIND_SLASH_LV2(104, 0.3, 3, 0, 5),
    WIND_SLASH_LV3(120, 0.35, 3, 0, 5),

    TORNADO(130, 0.4, 5, 0, 7),
    TORNADO_LV2(150, 0.45, 4, 0, 7),
    TORNADO_LV3(173, 0.5, 4, 0, 7),

    AIR_STRIKE(95, 0.3, 3, 0, 5),
    AIR_STRIKE_LV2(110, 0.35, 2, 0, 5),
    AIR_STRIKE_LV3(127, 0.4, 2, 0, 5);

    private final int baseDamage;
    private final double damageRatio;
    private final int cooldown;
    private final int upgradeLevel;
    private final int maxUpgradeLevel;

    Skill(int baseDamage, double damageRatio, int cooldown, int upgradeLevel, int maxUpgradeLevel) {
        this.baseDamage = baseDamage;
        this.damageRatio = damageRatio;
        this.cooldown = cooldown;
        this.upgradeLevel = upgradeLevel;
        this.maxUpgradeLevel = maxUpgradeLevel;
    }

}