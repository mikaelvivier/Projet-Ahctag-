package com.imt.demo.dto;

public enum Skill {

    // Compétences de type Feu
    FIREBALL(100, 0.2, 3, 0, 5),
    FLAME_BURST(120, 0.3, 4, 0, 5),
    INFERNO(150, 0.5, 5, 0, 6),

    // Compétences de type Eau
    WATER_BLAST(85, 0.3, 2, 0, 4),
    TIDAL_WAVE(110, 0.35, 3, 0, 5),
    AQUA_JET(90, 0.25, 2, 0, 4),

    // Compétences de type Vent
    WIND_SLASH(90, 0.25, 4, 0, 5),
    TORNADO(130, 0.4, 5, 0, 7),
    AIR_STRIKE(95, 0.3, 3, 0, 5);

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

    public int getBaseDamage() {
        return baseDamage;
    }

    public double getDamageRatio() {
        return damageRatio;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public int getMaxUpgradeLevel() {
        return maxUpgradeLevel;
    }
}