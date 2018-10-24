package com.company;
/**
 *  The Monk is the class to set a new monk unit.
 *  This unit can be attacked and can heal other units.
 *
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
    public void heal(Attacker toHeal){
        if(!this.getUnitHp().isDead()) {
            toHeal.healedByMonk(this);
        }
    }

    /**
     * This method is used when an
     * infantry unit attack this unit.
     * @param infantry
     */
    @Override
    public void attackedByInfantry(Infantry infantry) {

    }

    /**
     * This method is used when a
     * cavalry attacks this unit.
     * @param cavalry
     */
    @Override
    public void attackedByCavalry(Cavalry cavalry) {

    }

    /**
     * This method is used when an
     * archer unit attack this unit.
     * @param archer
     */
    @Override
    public void attackedByArcher(Archer archer) {

    }

    /**
     * This method is used when a
     * siege unit attack this unit.
     * @param siege
     */
    @Override
    public void attackedBySiege(Siege siege) {

    }

    /**
     * This method is used when a
     * villager unit attack this unit.
     * @param villager
     */
    @Override
    public void attackedByVillager(Villager villager) {

    }

    /**
     * This method is used when a
     * monk unit heals this unit.
     * @param monk
     */
    @Override
    public void healedByMonk(Monk monk) {
        this.getUnitHp().addtHP(monk.getAtk() * 0.5);
    }
}
