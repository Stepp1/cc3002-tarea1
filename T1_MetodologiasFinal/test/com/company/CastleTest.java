package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CastleTest {
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

        castle = new Castle(500.0);
        barracks = new Barracks(500.0);
    }
    @Test
    public void attack() {
        castle.attack(villager);
        assertEquals("expected to deal damage", 70, villager.getUnitHp().getHp(), DELTA);
    }

    @Test
    public void attackedByInfantry() {
        castle.attackedByInfantry(infantry);
        assertEquals("check damage dealt by Infantry", 485, castle.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void attackedByCavalry() {
        castle.attackedByCavalry(cavalry);
        assertEquals("check damage dealt by Cavalry", 485, castle.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void attackedByArcher() {
        castle.attackedByArcher(archer);
        assertEquals("check damage dealt by Archer", 495, castle.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void attackedBySiege() {
        castle.attackedBySiege(siege);
        assertEquals("check damage dealt by Siege", 400, castle.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void attackedByVillager() {
        castle.attackedByVillager(villager);
        assertEquals("check repair done by Villager", 515, castle.getBuildingHp().getHp(), DELTA);

        castle.attackedByInfantry(infantry); // 500 hp
        castle.attackedByInfantry(infantry); // 485 hp
        assertEquals("check damage after repairs", 485, castle.getBuildingHp().getHp(), DELTA);
        castle.attackedByVillager(villager); // 500 hp
        assertEquals("check repairs", 500, castle.getBuildingHp().getHp(), DELTA);

        castle.attackedBySiege(siege); //400 hp
        castle.attackedBySiege(siege); //300 hp
        castle.attackedBySiege(siege); //200 hp
        castle.attackedBySiege(siege); //100 hp
        castle.attackedBySiege(siege); // 0 hp
        castle.attackedByVillager(villager); // does nothing
        assertEquals("check if destroyed", 0,castle.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void attackedByCastle() {
        castle.attackedByCastle(castle);
        assertEquals("check damage dealt by Castle", 497.5, castle.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void healedByMonk() {
        castle.healedByMonk(monk);
        assertEquals("Monk does nothing to Castle", 500, castle.getBuildingHp().getHp(), DELTA);
    }
}