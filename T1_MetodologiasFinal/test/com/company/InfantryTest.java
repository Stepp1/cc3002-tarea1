package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InfantryTest {
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
        infantry.attack(cavalry);
        assertEquals("expected to deal damage", 40.0, cavalry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByInfantry() {
        infantry.attackedByInfantry(infantry);
        assertEquals("check damage dealt by Infantry", 50.0, infantry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByCavalry() {
        infantry.attackedByCavalry(cavalry);
        assertEquals("check damage dealt by Cavalry", 50.0, infantry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByArcher() {
        infantry.attackedByArcher(archer);
        assertEquals("check damage dealt by Archer", 40.0, infantry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedBySiege() {
        infantry.attackedBySiege(siege);
        assertEquals("check damage dealt by Siege", 25.0, infantry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByVillager() {
        infantry.attackedByVillager(villager);
        assertEquals("check damage dealt by Villager", 60.0, infantry.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void healedByMonk() {
        infantry.healedByMonk(monk);
        assertEquals("check heal done by Monk", infantry.getUnitHp().getHp(), 125.0, DELTA);

        infantry.attackedByVillager(villager);
        assertEquals("check dmg done by Monk", infantry.getUnitHp().getHp(), 85.0, DELTA);

        infantry.attackedByVillager(villager);
        infantry.healedByMonk(monk);
        assertEquals("check heal done by Monk", infantry.getUnitHp().getHp(), 70.0, DELTA);

        infantry.attackedByVillager(villager); // 30 hp left
        infantry.attackedByVillager(villager); // 0 hp left, "-10 hp"
        assertEquals("check if heal is not done by Monk", infantry.getUnitHp().getHp(), 0.0, DELTA);
    }

    @Test
    public void attackedByCastle() {
        infantry.attackedByCastle(castle);
        assertEquals("check damage dealt by Castle", 97.0, infantry.getUnitHp().getHp(), DELTA);
    }
}