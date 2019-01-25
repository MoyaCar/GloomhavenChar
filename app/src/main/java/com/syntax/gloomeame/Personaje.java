package com.syntax.gloomeame;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "personajes_table")
public class Personaje {

    @PrimaryKey(autoGenerate = true)
    private int cId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "job_class")
    private int jobClass;

    @ColumnInfo(name = "level")
    private int level;

    @ColumnInfo(name = "exp")
    private int exp;

    @ColumnInfo(name = "max_hp")
    private int maxHp;

    @ColumnInfo(name = "actual_hp")
    private int actualHp;

    @ColumnInfo(name = "actual_xp")
    private int actualExp;

    @ColumnInfo(name = "actual_gold")
    private int actualGold;

    @ColumnInfo(name = "items")
    private String items;

    public Personaje() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJobClass() {
        return jobClass;
    }

    public void setJobClass(int jobClass) {
        this.jobClass = jobClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getActualHp() {
        return actualHp;
    }

    public void setActualHp(int actualHp) {
        this.actualHp = actualHp;
    }

    public int getActualExp() {
        return actualExp;
    }

    public void setActualExp(int actualExp) {
        this.actualExp = actualExp;
    }

    public int getActualGold() {
        return actualGold;
    }

    public void setActualGold(int actualGold) {
        this.actualGold = actualGold;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
