package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VillagerTest {
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
        villager.attack(archer);
        assertEquals("expected to deal damage", 50.0, archer.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByInfantry() {
        villager.attackedByInfantry(infantry);
        assertEquals("check damage dealt by Infantry", 25.0, villager.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByCavalry() {
        villager.attackedByCavalry(cavalry);
        assertEquals("check damage dealt by Cavalry", 25.0, villager.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByArcher() {
        villager.attackedByArcher(archer);
        assertEquals("check damage dealt by Archer", 25.0, villager.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedBySiege() {
        villager.attackedBySiege(siege);
        assertEquals("check damage dealt by Siege", 25.0, villager.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByVillager() {
        villager.attackedByVillager(villager);
        assertEquals("check damage dealt by Villager", 50.0, villager.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void healedByMonk() {
        villager.healedByMonk(monk);
        assertEquals("check heal done by Monk", villager.getUnitHp().getHp(), 125.0, DELTA);

        villager.attackedByInfantry(infantry);
        assertEquals("check dmg done by Infantry ", villager.getUnitHp().getHp(), 50.0, DELTA);

        villager.healedByMonk(monk);
        assertEquals("check heal done by Monk", villager.getUnitHp().getHp(), 75.0, DELTA);

        villager.attackedByInfantry(infantry); // 0 hp left
        assertEquals("check if heal is not done by Monk", villager.getUnitHp().getHp(), 0.0, DELTA);
    }

    @Test
    public void attackedByCastle() {
        villager.attackedByCastle(castle);
        assertEquals("check damage dealt by Castle", 97.0, villager.getUnitHp().getHp(), DELTA);
    }
}