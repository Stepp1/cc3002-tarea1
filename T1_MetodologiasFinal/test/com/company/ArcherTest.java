package com.company;

import org.junit.Test;
import org.junit.Before;
import sun.jvm.hotspot.debugger.windbg.DLL;

import static org.junit.Assert.*;

public class ArcherTest {
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
    public void setUp() {
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
        archer.attack(siege);
        assertEquals("expected to deal damage", siege.getUnitHp().getHp(), 60.0, DELTA);
    }

    @Test
    public void attackedByInfantry() {
        archer.attackedByInfantry(infantry);
        assertEquals("check damage dealt by Infantry", archer.getUnitHp().getHp(), 40.0 , DELTA);
    }

    @Test
    public void attackedByCavalry() {
        archer.attackedByCavalry(cavalry);
        assertEquals("check damage dealt by Cavalry", archer.getUnitHp().getHp(), 25.0 , DELTA);
    }

    @Test
    public void attackedByArcher() {
        archer.attackedByArcher(archer);
        assertEquals("check damage dealt by Archer", archer.getUnitHp().getHp(), 40.0, DELTA);
    }

    @Test
    public void attackedBySiege() {
        archer.attackedBySiege(siege);
        assertEquals("check damage dealt by Siege", archer.getUnitHp().getHp(), 25.0, DELTA);
    }

    @Test
    public void attackedByVillager() {
        archer.attackedByVillager(villager);
        assertEquals("check damage dealt by Villager", archer.getUnitHp().getHp(), 50.0, DELTA);
    }

    @Test
    public void healedByMonk() {
        archer.healedByMonk(monk);
        assertEquals("check heal done by Monk", archer.getUnitHp().getHp(), 125.0, DELTA);

        archer.attackedByVillager(villager);
        assertEquals("check heal done by Monk", archer.getUnitHp().getHp(), 75.0, DELTA);

        archer.attackedByVillager(villager); // 50 hp left
        archer.attackedByVillager(villager); // 0 hp left
        assertEquals("check if heal is not done by Monk", archer.getUnitHp().getHp(), 0.0, DELTA);
    }

    @Test
    public void attackedByCastle() {
        archer.attackedByCastle(castle);
        assertEquals("check damage dealt by Castle", archer.getUnitHp().getHp(), 40.0, DELTA);
    }


}