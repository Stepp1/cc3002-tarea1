package com.company;

/**
 *
 *  Villager.java
 *
 *  The Villager is the class to set a new villager unit.
 *  This unit can be attacked, can attack back and can also repair.
 *  This class contains methods that produce the corresponding effect
 *  when the unit is attacked. They contain the corresponding attack multiplier.
 */
public class Villager extends AbstractUnit{

    /**
     * Instantiates a new Villager unit
     * @param life the hp of this unit
     * @param atk the attack points of this unit
     */

    public Villager(double life, double atk){
        super(life,atk);
    }

    /**
     *  This method is used to attack or repair
     *  another unit or building
     * @param toAttack the unit or building to attack or repair
     */
    @Override
    public void attack(Attackable toAttack){
        if(!this.getUnitHp().isDead()) {
            toAttack.attackedByVillager(this);
        }
    }

    /**
     * This method is used when an
     * infantry unit attack this unit.
     * @param infantry the attacking unit
     */
    @Override
    public void attackedByInfantry(Infantry infantry) {
        this.getUnitHp().substractHP(infantry.getAtk() * 1.5);
    }

    /**
     * This method is used when a
     * cavalry attacks this unit.
     * @param cavalry the attacking unit
     */
    @Override
    public void attackedByCavalry(Cavalry cavalry) {
        this.getUnitHp().substractHP(cavalry.getAtk() * 1.5);
    }

    /**
     * This method is used when an
     * archer unit attack this unit.
     * @param archer the attacking unit
     */
    @Override
    public void attackedByArcher(Archer archer) {
        this.getUnitHp().substractHP(archer.getAtk() * 1.5);
    }

    /**
     * This method is used when a
     * siege unit attack this unit.
     * @param siege the attacking unit
     */
    @Override
    public void attackedBySiege(Siege siege) {
        this.getUnitHp().substractHP(siege.getAtk() * 1.5);
    }

    /**
     * This method is used when a
     * villager unit attack this unit.
     * @param villager the attacking unit
     */
    @Override
    public void attackedByVillager(Villager villager) {
        this.getUnitHp().substractHP(villager.getAtk() * 1.0);
    }

    /**
     * This method is used when a
     * monk unit heals this unit.
     * @param monk the healing unit
     */
    @Override
    public void healedByMonk(Monk monk) {
            this.getUnitHp().addtHP(monk.getAtk() * 0.5);
    }

    /**
     * This method is used when a castle
     * building attacks this unit.
     * @param castle the attacking building
     */
    @Override
    public void attackedByCastle(Castle castle) {
        this.getUnitHp().substractHP(castle.getAtk() * 1.2);
    }
}
