package com.company;

/**
 *
 * AbstracBuilding.java
 *
 * AbstractUnit is the abstract class for all Units.
 * This class allows the definition of the entity Unit.
 * It gives them hit points and attack points.
 * Only the subclass Castle can attack for now.
 *
 * @author Stepp
 */
public abstract class AbstractBuilding implements Attackable {
    /** Hit Points */
    private HitPoints hp;

    /** Attack Points*/
    private double atk;

    /**
     * Instantiates a new abstract building.
     *
     * @param hp sets the hit points and the hpCap
     */
    public AbstractBuilding(double hp){
        this.atk = hp;
        this.hp = new HitPoints(hp);
        this.hp.setHpCapBuilding();
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
