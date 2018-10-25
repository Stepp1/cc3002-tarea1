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

    /** The hp cap of an unit*/
    private double hpCap;

    /**
     * Instantiates a new Hit Points class.
     * @param hp
     */
    public HitPoints(double hp){
        this.hp = hp;
        this.hpCap = hp * 2.0;
    }

    /**
     * This method returns the current hp
     * of an unit
     * @return the actual life
     */
    public double getHp(){
        return hp;
    }


    /**
     * This method returns the hp cap
     * of an unit
     * @return the life cap
     */
    public double getHpCapUnit(){
        return hpCap;
    }


    /**
     * This method returns the hp cap
     * of an unit
     * @return the life cap
     */
    public double getHpCapBuilding(){
        return hpCap;
    }


    /**
     * This method is used to set
     * the hp cap of an unit
     * @return the corresponding hp cap
     */
    public void setHpCapUnit(){
        this.hpCap = hp * 2.0;
    }


    /**
     * This method is used to set
     * the hp cap of a building
     * @return the corresponding hp cap
     */
    public void setHpCapBuilding(){
        this.hpCap = hp * 2.0;
    }


    /**
     * This method is used to reduce the
     * current hp of an unit
     * @param damage
     */
    public void substractHP(double damage){
        this.hp -= damage;
        if(this.hp <= 0){
            this.setDead();
        }
    }


    /**
     * This method is used to set the unit to
     * a dead state.
     */
    public void setDead(){
        this.hp = 0;
    }

    /**
     * This method is used to set the unit to
     * a its hp cap.
     */
    public void setMaxHp(){
        this.hp = this.hpCap;
    }


    /**
     * This method is used to add more hp, a.k.a heal,
     * the current hp of an unit
     * @param heal
     */
    public void addtHP(double heal){
        this.hp += heal;
        if(this.hp > this.hpCap){
            this.setMaxHp();
        }
    }


    /**
     * This method checks if the unit is dead.
     * Therefore, it checks if the hp is inferior
     * or equal to zero.
     * @return
     */
    public boolean isDead() {
        return hp <= 0;
    }


}
