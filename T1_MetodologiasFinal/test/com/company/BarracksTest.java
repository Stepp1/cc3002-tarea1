package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarracksTest {
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
    public void attackedByInfantry() {
        barracks.attackedByInfantry(infantry);
        assertEquals("check damage dealt by Infantry", 465, barracks.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void attackedByCavalry() {
        barracks.attackedByCavalry(cavalry);
        assertEquals("check damage dealt by Infantry", 465, barracks.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void attackedByArcher() {
        barracks.attackedByArcher(archer);
        assertEquals("check damage dealt by Infantry", 465, barracks.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void attackedBySiege() {
        barracks.attackedBySiege(siege);
        assertEquals("check damage dealt by Infantry", 400, barracks.getBuildingHp().getHp(),DELTA);
    }

    @Test
    public void attackedByVillager() {
        barracks.attackedByVillager(villager);
        assertEquals("check repair done by Villager", 535, barracks.getBuildingHp().getHp(), DELTA);

        barracks.attackedByInfantry(infantry); // 500 hp
        barracks.attackedByInfantry(infantry); // 465 hp
        assertEquals("check damage after repairs", 465, barracks.getBuildingHp().getHp(), DELTA);
        barracks.attackedByVillager(villager); // 500 hp
        assertEquals("check repairs", 500, barracks.getBuildingHp().getHp(), DELTA);

        barracks.attackedBySiege(siege); //400 hp
        barracks.attackedBySiege(siege); //300 hp
        barracks.attackedBySiege(siege); //200 hp
        barracks.attackedBySiege(siege); // 100 hp
        barracks.attackedBySiege(siege); // 0 hp
        barracks.attackedByVillager(villager); // does nothing
        assertEquals("check if destroyed", 0,barracks.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void attackedByCastle() {
        barracks.attackedByCastle(castle);
        assertEquals("check damage dealt by Castle", 482.5, barracks.getBuildingHp().getHp(), DELTA);
    }

    @Test
    public void healedByMonk() {
        barracks.healedByMonk(monk);
        assertEquals("Monk does nothing to Castle", 500, barracks.getBuildingHp().getHp(), DELTA);
    }
}