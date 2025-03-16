package com.imt.demo.dto;

import lombok.Getter;

@Getter
public enum Skill {

    // Compétences de type Feu
    FIREBALL_LV1(100, 0.2, 1, 0, 5),
    FIREBALL_LV2(115, 0.25, 1, 0, 5),
    FIREBALL_LV3(132, 0.3, 1, 0, 5),

    FLAME_BURST_LV1(120, 0.3, 2, 0, 5),
    FLAME_BURST_LV2(138, 0.35, 2, 0, 5),
    FLAME_BURST_LV3(159, 0.4, 2, 0, 5),

    INFERNO_LV1(150, 0.5, 3, 0, 6),
    INFERNO_LV2(173, 0.55, 3, 0, 6),
    INFERNO_LV3(199, 0.6, 3, 0, 6),

    // Compétences de type Eau
    WATER_BLAST_LV1(85, 0.3, 1, 0, 4),
    WATER_BLAST_LV2(98, 0.35, 1, 0, 4),
    WATER_BLAST_LV3(113, 0.4, 1, 0, 4),

    TIDAL_WAVE_LV1(110, 0.35, 2, 0, 5),
    TIDAL_WAVE_LV2(126, 0.4, 2, 0, 5),
    TIDAL_WAVE_LV3(145, 0.45, 2, 0, 5),

    AQUA_JET_LV1(90, 0.25, 3, 0, 4),
    AQUA_JET_LV2(104, 0.3, 3, 0, 4),
    AQUA_JET_LV3(120, 0.35,  3, 0, 4),

    // Compétences de type Vent
    WIND_SLASH_LV1(90, 0.25, 1, 0, 5),
    WIND_SLASH_LV2(104, 0.3, 1, 0, 5),
    WIND_SLASH_LV3(120, 0.35, 1, 0, 5),

    TORNADO_LV1(130, 0.4, 2, 0, 7),
    TORNADO_LV2(150, 0.45, 2, 0, 7),
    TORNADO_LV3(173, 0.5, 2, 0, 7),

    AIR_STRIKE_LV1(95, 0.3, 3, 0, 5),
    AIR_STRIKE_LV2(110, 0.35, 3, 0, 5),
    AIR_STRIKE_LV3(127, 0.4, 3, 0, 5);

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