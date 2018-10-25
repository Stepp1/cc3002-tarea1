package com.company;
/**
 *
 *  Monk.java
 *
 *  The Monk is the class to set a new monk unit.
 *  This unit can be attacked and can heal other units.
 *  This class contains the attack method. It allows the unit to attack buildings or other units.
 *  This class contains methods that produce the corresponding effect when the unit is attacked.
 *  When a monk is attacked it automatically dies.

 */
public class Monk extends AbstractUnit{

    /**
     * Instantiates a new Monk unit
     *
     * The attack points of a Monk are 
     * related to his capacity to his
     * capacity to heal other units.
     *
     * @param life the hp of this unit
     * @param atk the attack points of this unit, these are used for healing purposes.
     */

    public Monk(HitPoints life, double atk){
        super(life,atk);
    }

    /**
     *  This method is used to heal another unit
     * @param toHeal or building to attack
     */
    @Override
    public void attack(Attackable toHeal){
        if(!this.getUnitHp().isDead()) {
            toHeal.healedByMonk(this);
        }
    }

    /**
     * This method is used when an
     * infantry unit attack this unit.
     * @param infantry the attacking unit
     */
    @Override
    public void attackedByInfantry(Infantry infantry) {
        this.getUnitHp().setDead();
    }

    /**
     * This method is used when a
     * cavalry attacks this unit.
     * @param cavalry the attacking unit
     */
    @Override
    public void attackedByCavalry(Cavalry cavalry) {
        this.getUnitHp().setDead();
    }

    /**
     * This method is used when an
     * archer unit attack this unit.
     * @param archer the attacking unit
     */
    @Override
    public void attackedByArcher(Archer archer) {
        this.getUnitHp().setDead();
    }

    /**
     * This method is used when a
     * siege unit attack this unit.
     * @param siege the attacking unit
     */
    @Override
    public void attackedBySiege(Siege siege) {
        this.getUnitHp().setDead();
    }

    /**
     * This method is used when a villager
     * unit tries to attack this unit.
     * A villager cannot attack a monk.
     * @param villager the attacking unit
     */
    @Override
    public void attackedByVillager(Villager villager) {
        //do nothing
    }

    /**
     * This method is used when a castle
     * building attacks this unit.
     * @param castle the attacking building
     */
    @Override
    public void attackedByCastle(Castle castle) {
        this.getUnitHp().setDead();
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

}
