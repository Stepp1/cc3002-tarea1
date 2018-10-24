package com.company;

/**
 *  The Archer is the class to set a new archer unit.
 *  This unit can be attacked and attack back.
 *
 */
public class Archer extends AbstractUnit{

    /**
     * Instantiates a new Archer unit
     * @param life the hp of this unit
     * @param atk the attack points of this unit
     */

    public Archer(HitPoints life, double atk){
        super(life,atk);
    }

    /**
     *  This method is used to attack
     *  another unit or building
     * @param toAttack the unit or building to attack
     */
    public void attack(AttackableUnits toAttack){
        if(!this.getUnitHp().isDead()) {
            toAttack.attackedByArcher(this);
        }
    }

    /**
     * This method is used when an
     * infantry unit attack this unit.
     * @param infantry
     */
    @Override
    public void attackedByInfantry(Infantry infantry) {
        this.getUnitHp().substractHP(infantry.getAtk() * 1.2);
    }

    /**
     * This method is used when a
     * cavalry attacks this unit.
     * @param cavalry
     */
    @Override
    public void attackedByCavalry(Cavalry cavalry) {
        this.getUnitHp().substractHP(cavalry.getAtk() * 1.5);
    }

    /**
     * This method is used when an
     * archer unit attack this unit.
     * @param archer
     */
    @Override
    public void attackedByArcher(Archer archer) {
        this.getUnitHp().substractHP(archer.getAtk() * 1.2);
    }

    /**
     * This method is used when a
     * siege unit attack this unit.
     * @param siege
     */
    @Override
    public void attackedBySiege(Siege siege) {
        this.getUnitHp().substractHP(siege.getAtk() * 1.5);
    }

    /**
     * This method is used when a
     * villager unit attack this unit.
     * @param villager
     */
    @Override
    public void attackedByVillager(Villager villager) {
        this.getUnitHp().substractHP(villager.getAtk() * 1.0);
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
