package com.twistral.entities;

import javax.swing.*;

public abstract class AbstractMonster {

    private final int damage;
    private final float meleeRes;  // yuzde 0 1
    private final float rangedRes; // yuzde 0 1
    private final int evade; // yuzde 0 100
    private final int loot;
    private final String name;
    private final ImageIcon icon;

    private int health;
    private int maxHealth;


    public AbstractMonster(int health, int damage, float meleeRes, float rangedRes, int evade, int loot, String name, ImageIcon icon) {
        this.evade = evade;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.icon = icon;
        this.meleeRes = meleeRes;
        this.rangedRes = rangedRes;
        this.loot = loot;
        this.name = name;
    }

    // setters


    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    // getters
    public float getMeleeRes() {return meleeRes;}
    public int getHealth() {return health;}
    public int getMaxHealth() {return maxHealth;}
    public int getDamage() {return damage;}
    public float getRangedRes() {return rangedRes;}
    public int getEvade() {return evade;}
    public int getLoot() {return loot;}
    public String getName() {return name;}
    public ImageIcon getIcon() {return icon;}

}
