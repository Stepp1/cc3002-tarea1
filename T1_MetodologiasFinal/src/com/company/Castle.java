package com.company;


/**
 *  The Castle is the class to set a new castle building.
 *  This building can be attacked and attack back.
 *  It can be repaired.
 */

public class Castle extends AbstractBuilding implements Attacker{


    /**
     * Instantiates a new Castle building
     * @param life the hp of this unit
     * @param atk the attack points of this unit
     */

    public Castle(HitPoints life, double atk){
        super(life);
    }

    
    @Override
    public void attack(Attackable entity) {
        if(!this.getUnitHp().isDead()) {
            entity.attackedByCastle(this);
        }
    }

    @Override
    public void attackedByInfantry(Infantry infantry) {
        this.getUnitHp().substractHP(infantry.getAtk() * 0.3);
    }

    @Override
    public void attackedByCavalry(Cavalry cavalry) {
        this.getUnitHp().substractHP(cavalry.getAtk() * 0.1);        
    }

    @Override
    public void attackedByArcher(Archer archer) {
        this.getUnitHp().substractHP(archer.getAtk() * 0.3);
    }

    @Override
    public void attackedBySiege(Siege siege) {
        this.getUnitHp().substractHP(siege.getAtk() * 2.0);
    }

    @Override
    public void attackedByVillager(Villager villager) {
        this.getUnitHp().addtHP(villager.getAtk() * 0.3);
    }

    @Override
    public void attackedByCastle(Castle castle) {
        this.getUnitHp().substractHP(castle.getAtk() * 0.1);
    }

    @Override
    public void healedByMonk(Monk monk) {
        //do nothing
    }
}
