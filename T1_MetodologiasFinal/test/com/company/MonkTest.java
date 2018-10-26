package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonkTest {
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
    public void attack() { //heal done by monk
        monk.attack(villager);
        assertEquals("expected to heal", 125.0, villager.getUnitHp().getHp(), DELTA);

        villager.attack(villager);
        assertEquals("expected to have damage done", 75.0, villager.getUnitHp().getHp(), DELTA);

        monk.attack(villager);
        assertEquals("expected to heal", 100.0, villager.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByInfantry() {
        monk.attackedByInfantry(infantry);
        assertEquals("expected to be dead", 0.0, monk.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByCavalry() {
        monk.attackedByCavalry(cavalry);
        assertEquals("expected to be dead", 0.0, monk.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByArcher() {
        monk.attackedByArcher(archer);
        assertEquals("expected to be dead", 0.0, monk.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedBySiege() {
        monk.attackedBySiege(siege);
        assertEquals("expected to be dead", 0.0, monk.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByVillager() {
        monk.attackedByVillager(villager);
        assertEquals("expected to be alive and at full hp", 100.0, monk.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByCastle() {
        monk.attackedByCastle(castle);
        assertEquals("expected to be dead", 0.0, monk.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void healedByMonk() {
        monk.attackedByInfantry(infantry);
        assertEquals("expected to be dead", 0.0, monk.getUnitHp().getHp(), DELTA);
        monk.healedByMonk(monk);
        assertEquals("expected to still be dead", 0.0, monk.getUnitHp().getHp(), DELTA);
    }
}