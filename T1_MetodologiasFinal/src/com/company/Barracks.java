package com.company;

/**
 *
 *  Barracks.java
 *
 *  The Barracks is the class to set a new Barracks building.
 *  This building cannot attack.
 *  It can be repaired.
 *  This class contains methods that produce the corresponding effect when the building is attacked.
 *  These methods contain the corresponding attack multiplier.
 */

public class Barracks extends AbstractBuilding{

    /**
     * Instantiates a new Barracks building
     * @param life the hp of this unit
     */
    public Barracks(double life){
        super(life);
    }

    /**
     * This method is used when an
     * infantry unit attack this unit.
     * @param infantry the attacking unit
     */
    @Override
    public void attackedByInfantry(Infantry infantry) {
        this.getBuildingHp().substractHP(infantry.getAtk() * 0.7);
    }
    /**
     * This method is used when a
     * cavalry attacks this unit.
     * @param cavalry the attacking unit
     */
    @Override
    public void attackedByCavalry(Cavalry cavalry) {
        this.getBuildingHp().substractHP(cavalry.getAtk() * 0.7);
    }

    /**
     * This method is used when an
     * archer unit attack this unit.
     * @param archer the attacking unit
     */
    @Override
    public void attackedByArcher(Archer archer) {
        this.getBuildingHp().substractHP(archer.getAtk() * 0.7);
    }

    /**
     * This method is used when a
     * siege unit attack this unit.
     * @param siege the attacking unit
     */
    @Override
    public void attackedBySiege(Siege siege) {
        this.getBuildingHp().substractHP(siege.getAtk() * 2.0);
    }

    /**
     * This method is used when a
     * villager unit attack this unit.
     * @param villager the attacking unit
     */
    @Override
    public void attackedByVillager(Villager villager) {
        this.getBuildingHp().addtHP(villager.getAtk() * 0.7);
    }

    /**
     * This method is used when a castle
     * building attacks this unit.
     * @param castle the attacking building
     */
    @Override
    public void attackedByCastle(Castle castle) {
        this.getBuildingHp().substractHP(castle.getAtk() * 0.7);
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