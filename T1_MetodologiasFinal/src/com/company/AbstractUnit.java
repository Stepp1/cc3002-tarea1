package com.company;

/**
 *
 * AbstractUnit.java
 *
 * AbstractUnit is the abstract class for all Units.
 * This class allows the definition of the entity Unit.
 * It gives them hit points and attack points.
 * All subclasses attack except for Monk that heals other units.
 * The Villager Unit can repair Buildings.
 *
 * @author Stepp
 */

public abstract class AbstractUnit implements Attackable,Attacker {
    /** Hit Points */
    private HitPoints hp;

    /** Attack Points*/
    private double atk;

    /**
     * Instantiates a new abstract unit.
     *
     * @param hp sets the hit points and the hpCap
     * @param atk sets the attack points.
     */
    public AbstractUnit(HitPoints hp, double atk){
        this.atk = atk;
        this.hp = hp;
        this.hp.setHpCapUnit();
    }

    /**
     * Gets the hit points of a unit.
     *
     * @return the hit points
     */
    public HitPoints getUnitHp(){
        return hp;
    }

    /**
     * Gets the attack points of a unit.
     *
     * @return the attack points
     */
    public double getAtk() {
        return atk;
    }


}