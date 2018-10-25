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

    /**
     * This method is used when an
     * infantry unit attack this unit.
     * @param infantry the attacking unit
     */
    @Override
    public void attackedByInfantry(Infantry infantry) {
        this.getUnitHp().substractHP(infantry.getAtk() * 0.7);
    }
    /**
     * This method is used when a
     * cavalry attacks this unit.
     * @param cavalry the attacking unit
     */
    @Override
    public void attackedByCavalry(Cavalry cavalry) {
        this.getUnitHp().substractHP(cavalry.getAtk() * 0.7);
    }

    /**
     * This method is used when an
     * archer unit attack this unit.
     * @param archer the attacking unit
     */
    @Override
    public void attackedByArcher(Archer archer) {
        this.getUnitHp().substractHP(archer.getAtk() * 0.7);
    }

    /**
     * This method is used when a
     * siege unit attack this unit.
     * @param siege the attacking unit
     */
    @Override
    public void attackedBySiege(Siege siege) {
        this.getUnitHp().substractHP(siege.getAtk() * 2.0);
    }

    /**
     * This method is used when a
     * villager unit attack this unit.
     * @param villager the attacking unit
     */
    @Override
    public void attackedByVillager(Villager villager) {
        this.getUnitHp().addtHP(villager.getAtk() * 0.7);
    }

    /**
     * This method is used when a castle
     * building attacks this unit.
     * @param castle the attacking building
     */
    @Override
    public void attackedByCastle(Castle castle) {
        this.getUnitHp().substractHP(castle.getAtk() * 0.7);
    }

    /**
     * This method is used when a
     * monk unit heals this unit.
     * @param monk the healing unit
     */
    @Override
    public void healedByMonk(Monk monk) {
        //do nothing
    }
}