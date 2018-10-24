package com.company;

/**
 * AbstractUnit is the abstract class for all Units.
 * This class allows the definition of the entity Unit.
 * It gives them hit points.
 *
 * @author Stepp
 */

public abstract class AbstractUnit implements AttackableUnits,Attacker {
    /** Hit Points */
    private HitPoints hp;

    /** Attack Points*/
    private double atk;

    /**
     * Instantiates a new abstract unit.
     *
     * @param hp sets the hit points.
     * @param atk sets the attack points.
     */
    public AbstractUnit(HitPoints hp, double atk){
        this.atk = atk;
        this.hp = hp;
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