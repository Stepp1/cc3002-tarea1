package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SiegeTest {
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

        castle = new Castle(1000.0);
        barracks = new Barracks(1000.0);
    }

    @Test
    public void attack() {
        siege.attack(barracks);
        assertEquals("expected to deal damage", 900.0,  barracks.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void attackedByInfantry() {
        siege.attackedByInfantry(infantry);
        assertEquals("check damage dealt by Infantry", 40.0,  siege.getUnitHp().getHp(), DELTA);

    }

    @Test
    public void attackedByCavalry() {
        siege.attackedByCavalry(cavalry);
        assertEquals("check damage dealt by cavalry", 40.0 , siege.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByArcher() {
        siege.attackedByArcher(archer);
        assertEquals("check damage dealt by archer", 60.0 , siege.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedBySiege() {
        siege.attackedBySiege(siege);
        assertEquals("check damage dealt by siege", 25.0 , siege.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByVillager() {
        siege.attackedByVillager(villager);
        assertEquals("check repair done by villager", 125.0 , siege.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void healedByMonk() {
        siege.healedByMonk(monk);
        assertEquals("check if monks does nothing", 100.0 , siege.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByCastle() {
        siege.attackedByCastle(castle);
        assertEquals("check damage dealt by castle", 40.0 , siege.getUnitHp().getHp(), DELTA);
    }
}