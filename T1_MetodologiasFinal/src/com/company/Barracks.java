package com.company;
/**
 *  The Barracks is the class to set a new Barracks building.
 *  This building cannot be attack, neither attack back.
 *  It can be repaired.
 */

public class Barracks extends AbstractBuilding{

    /**
     * Instantiates a new Barracks building
     * @param life the hp of this unit
     */

    public Barracks(HitPoints life){
        super(life);
    }


    @Override
    public void attackedByInfantry(Infantry infantry) {
        this.getUnitHp().substractHP(infantry.getAtk() * 0.7);
    }

    @Override
    public void attackedByCavalry(Cavalry cavalry) {
        this.getUnitHp().substractHP(cavalry.getAtk() * 0.7);
    }

    @Override
    public void attackedByArcher(Archer archer) {
        this.getUnitHp().substractHP(archer.getAtk() * 0.7);
    }

    @Override
    public void attackedBySiege(Siege siege) {
        this.getUnitHp().substractHP(siege.getAtk() * 2.0);
    }

    @Override
    public void attackedByVillager(Villager villager) {
        this.getUnitHp().addtHP(villager.getAtk() * 0.7);
    }

    @Override
    public void attackedByCastle(Castle castle) {
        this.getUnitHp().substractHP(castle.getAtk() * 0.7);
    }

    @Override
    public void healedByMonk(Monk monk) {
        //do nothing
    }
}