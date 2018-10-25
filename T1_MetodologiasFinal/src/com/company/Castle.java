package com.company;


/**
 *
 *  Castle.java
 *
 *  The Castle is the class to set a new castle building.
 *  This building can be attacked and attack back.
 *  It can be repaired.
 *  This class contains the attack method. It allows the unit to attack buildings or other units.
 *  This class contains methods that produce the corresponding effect when the building is attacked.
 *  These methods contain the corresponding attack multiplier.
 */

public class Castle extends AbstractBuilding implements Attacker{


    /**
     * Instantiates a new Castle building
     * @param life the hp of this unit
     */

    public Castle(HitPoints life){
        super(life);
    }

    
    @Override
    public void attack(Attackable entity) {
        if(!this.getUnitHp().isDead()) {
            entity.attackedByCastle(this);
        }
    }

    /**
     * This method is used when an
     * infantry unit attack this unit.
     * @param infantry the attacking unit
     */
    @Override
    public void attackedByInfantry(Infantry infantry) {
        this.getUnitHp().substractHP(infantry.getAtk() * 0.3);
    }

    /**
     * This method is used when a
     * cavalry attacks this unit.
     * @param cavalry the attacking unit
     */
    @Override
    public void attackedByCavalry(Cavalry cavalry) {
        this.getUnitHp().substractHP(cavalry.getAtk() * 0.1);        
    }

    /**
     * This method is used when an
     * archer unit attack this unit.
     * @param archer the attacking unit
     */
    @Override
    public void attackedByArcher(Archer archer) {
        this.getUnitHp().substractHP(archer.getAtk() * 0.3);
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
     * villager unit repairs this unit.
     * @param villager the repairing unit
     */
    @Override
    public void attackedByVillager(Villager villager) {
        this.getUnitHp().addtHP(villager.getAtk() * 0.3);
    }

    /**
     * This method is used when a castle
     * building attacks this unit.
     * @param castle the attacking building
     */
    @Override
    public void attackedByCastle(Castle castle) {
        this.getUnitHp().substractHP(castle.getAtk() * 0.1);
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
