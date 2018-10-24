package com.company;

/**
 *  The Siege is the class to set a new siege unit.
 *  This unit can be attacked and attack back.
 *
 */
public class Siege extends AbstractUnit{

    /**
     * Instantiates a new Siege unit
     * @param life the hp of this unit
     * @param atk the attack points of this unit
     */

    public Siege(HitPoints life, double atk){
        super(life,atk);
    }

    /**
     *  This method is used to attack
     *  another unit or building
     * @param toAttack the unit or building to attack
     */
    public void attack(AttackableUnits toAttack){
        if(!this.getUnitHp().isDead()) {
            toAttack.attackedBySiege(this);
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

    @Override
    public void repair(Villager villager) {

    }
}
