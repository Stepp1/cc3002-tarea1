package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CavalryTest {
    private static final double DELTA = 1e-15;

    private Archer archer;
    private Cavalry cavalry;
    private Infantry infantry;
    private Monk monk;
    private Siege siege;
    private Villager villager;

    private Castle castle;
    private Barracks barracks;

    @Before
    public void setUp() throws Exception {
        archer = new Archer(100.0,50.0);
        cavalry = new Cavalry(100.0,50.0);
        infantry = new Infantry(100.0,50.0);
        monk = new Monk(100.0,50.0);
        siege = new Siege(100.0,50.0);
        villager = new Villager(100.0,50.0);

        castle = new Castle(50.0);
        barracks = new Barracks(50.0);
    }

    @Test
    public void attack() {
        cavalry.attack(villager);
        assertEquals("expected to deal damage", 25.0, villager.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByInfantry() {
        cavalry.attackedByInfantry(infantry);
        assertEquals("check damage dealt by Infantry", 40.0, cavalry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByCavalry() {
        cavalry.attackedByCavalry(cavalry);
        assertEquals("check damage dealt by Cavalry", 50.0, cavalry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByArcher() {
        cavalry.attackedByArcher(archer);
        assertEquals("check damage dealt by Archer", 50.0, cavalry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedBySiege() {
        cavalry.attackedBySiege(siege);
        assertEquals("check damage dealt by Siege", 50.0, cavalry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByVillager() {
        cavalry.attackedByVillager(villager);
        assertEquals("check damage dealt by Villager", 75.0, cavalry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void healedByMonk() {
        cavalry.healedByMonk(monk);
        assertEquals("check heal done by Monk", cavalry.getUnitHp().getHp(), 125.0, DELTA);

        cavalry.attackedByVillager(villager);
        assertEquals("check dmg done by Villager ", cavalry.getUnitHp().getHp(), 100.0, DELTA);

        cavalry.attackedByVillager(villager);
        cavalry.attackedByVillager(villager);
        cavalry.healedByMonk(monk);
        assertEquals("check heal done by Monk", cavalry.getUnitHp().getHp(), 75.0, DELTA);

        cavalry.attackedByVillager(villager); // 50 hp left
        cavalry.attackedByVillager(villager); // 25 hp left
        cavalry.attackedByVillager(villager); // 0 hp left
        assertEquals("check if heal is not done by Monk", cavalry.getUnitHp().getHp(), 0.0, DELTA);
    }

    @Test
    public void attackedByCastle() {
        infantry.attackedByCastle(castle);
        assertEquals("check damage dealt by Castle", 97.0, infantry.getUnitHp().getHp(), DELTA);
    }
}