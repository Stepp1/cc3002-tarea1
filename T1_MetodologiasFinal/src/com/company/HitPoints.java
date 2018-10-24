package com.company;

/**
 * The class HitPoints is in charge of
 * managing the hp and the damage received
 * by each unit.
 *
 * @author Stepp
 */
public class HitPoints {
    /** Unused. It stores the damage made to an unit.*/
    private double damage;

    /** The hp of an unit*/
    private double hp;

    /**
     * Instantiates a new Hit Points class.
     * @param hp
     */
    public HitPoints(double hp){
        this.hp = hp;
    }

    /**
     * This method returns the current hp
     * of an unit
     * @return the actual life
     */
    private double getHp(){
        return hp;
    }

    /**
     * This method is used to reduce the
     * current hp of an unit
     * @param damage
     */
    public void substractHP(double damage){
        this.hp += damage;
    }

    /**
     * This method is used to add more hp, a.k.a heal,
     * the current hp of an unit
     * @param heal
     */
    public void addtHP(double heal){
        this.hp += heal;
    }

    /**
     * This method checks if the unit is dead.
     * Therefore, it checks if the hp is inferior
     * or equal to zero.
     * @return
     */
    public boolean isDead() {
        if(hp <= 0){
            return true;
        }
        else{
            return false;
        }
    }


}
