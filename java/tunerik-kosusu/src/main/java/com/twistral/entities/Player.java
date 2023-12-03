package com.twistral.entities;

import javax.swing.*;
import java.util.HashMap;

public final class Player {

    private ImageIcon characterImage;
    private String difficulty, chClass;
    private HashMap<String,Integer> inventory;
    private HashMap<String,Integer> currentEffects;
    private int meleeCrit;   // yuzde 0 100
    private int rangedCrit;  // yuzde 0 100
    private int maxHealth, curHealth, meleeDamage, rangedDamage, floor;
    private int evade;  // yuzde 0 100
    private int defense;
    private int money;
    private int level;
    private int experience;


    public Player(){
        this.characterImage = null;
        this.difficulty = null;
        this.chClass = null;
        this.maxHealth = 0;
        this.meleeDamage = 0;
        this.rangedDamage = 0;
        this.evade = 0;
        this.defense = 0;
        this.money = 0;
        this.level = 1;
        this.experience = 0;
        this.meleeCrit = 0;
        this.rangedCrit = 0;
        this.curHealth = 0;
        this.floor = 0;

        this.currentEffects = new HashMap<>();
        this.currentEffects.put("slowness1",0);
        this.currentEffects.put("slowness2",0);
        this.currentEffects.put("bleeding1",0);
        this.currentEffects.put("bleeding2",0);
        this.currentEffects.put("burning1",0);
        this.currentEffects.put("burning2",0);
        this.currentEffects.put("burning3",0);
        this.currentEffects.put("noDefense",0);
        this.currentEffects.put("regen1",0);
        this.currentEffects.put("regen2",0);
        this.currentEffects.put("regen3",0);
        this.currentEffects.put("strength",0);

        this.inventory = new HashMap<>();
        this.inventory.put("smallHealthPotion",0);
        this.inventory.put("mediumHealthPotion",0);
        this.inventory.put("largeHealthPotion",0);
        this.inventory.put("smallRegenerationPotion",0);
        this.inventory.put("mediumRegenerationPotion",0);
        this.inventory.put("largeRegenerationPotion",0);
        this.inventory.put("waterBottle",0);
        this.inventory.put("strengthPotion",0);
        this.inventory.put("antivenom",0);
        this.inventory.put("speedPotion",0);
    }

    public HashMap<String, Integer> getInventory() { return inventory; }

    public int getCurHealth() { return curHealth; }

    public void setCurHealth(int curHealth) { this.curHealth = curHealth; }

    public ImageIcon getCharacterImage() { return characterImage; }

    public void setCharacterImage(ImageIcon characterImage) { this.characterImage = characterImage; }

    public int getMoney() { return money; }

    public void setMoney(int money) { this.money = money; }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getChClass() {
        return chClass;
    }

    public void setChClass(String chClass) {
        this.chClass = chClass;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int health) {
        this.maxHealth = health;
    }

    public int getMeleeDamage() {
        return meleeDamage;
    }

    public void setMeleeDamage(int meleeDamage) {
        this.meleeDamage = meleeDamage;
    }

    public int getRangedDamage() {
        return rangedDamage;
    }

    public void setRangedDamage(int rangedDamage) {
        this.rangedDamage = rangedDamage;
    }

    public int getEvade() {
        return evade;
    }

    public void setEvade(int evade) {
        this.evade = evade;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMeleeCrit() { return meleeCrit; }

    public void setMeleeCrit(int meleeCrit) { this.meleeCrit = meleeCrit; }

    public int getRangedCrit() { return rangedCrit; }

    public void setRangedCrit(int rangedCrit) { this.rangedCrit = rangedCrit; }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }

    public int getExperience() { return experience; }

    public void setExperience(int experience) { this.experience = experience; }

    public HashMap<String, Integer> getCurrentEffects() { return currentEffects; }

}
