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
    @Override
    public void attack(Attackable toAttack){
        if(!this.getUnitHp().isDead()) {
            toAttack.attackedByArcher(this);
        }
    }

    /**
     * This method is used when an
     * infantry unit attacks this unit.
     * @param infantry the attacking unit
     */
    @Override
    public void attackedByInfantry(Infantry infantry) {
        this.getUnitHp().substractHP(infantry.getAtk() * 1.2);
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
     * archer unit attacks this unit.
     * @param archer the attacking unit
     */
    @Override
    public void attackedByArcher(Archer archer) {
        this.getUnitHp().substractHP(archer.getAtk() * 1.2);
    }

    /**
     * This method is used when a
     * siege unit attacks this unit.
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
        if (!this.getUnitHp().isDead()) {
            this.getUnitHp().addtHP(monk.getAtk() * 0.5);
        }
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
